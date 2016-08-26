/**
 * 
 */
package com.trusdom.fdip.services;

import java.math.BigDecimal;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trusdom.fdip.common.CodeBuilder;
import com.trusdom.fdip.common.Config;
import com.trusdom.fdip.common.HttpUtil;
import com.trusdom.fdip.common.Json;
import com.trusdom.fdip.form.BuyOrRedeForm;
import com.trusdom.fdip.mappers.AccountFundAmountMapper;
import com.trusdom.fdip.mappers.CapitalAllocationMapper;
import com.trusdom.fdip.model.Account;
import com.trusdom.fdip.model.AccountFundAmount;
import com.trusdom.fdip.model.CapitalAllocation;
import com.trusdom.fdip.model.Channel;
import com.trusdom.fdip.model.Fund;
import com.trusdom.fdip.model.Trade;
import com.trusdom.fdip.model.Trade.Status;
//import com.trusdom.fdip.model.Trade.TradeType;
import com.trusdom.fdip.vo.BuyResultVo;
import com.trusdom.fdip.vo.CbipFrozenOrUnFrozenResquestVo;
import com.trusdom.fdip.vo.CbipResponseVo;
import com.trusdom.fdip.vo.CbipTransferRequestVo;
import com.trusdom.fdip.vo.CbipTransferRequestVo.TradeType;
import com.trusdom.fdip.vo.ThsMcipBuyFundRequestVo;
import com.trusdom.fdip.vo.ThsMcipBuyFundResponseVo;
import com.trusdom.fdip.vo.UserVo;

/**
 * @author zhihuayang E-mail:425273175@qq.com
 * @date 创建时间：2016年5月16日 上午11:04:27
 * @version 1.0
 * @parameter
 * @return
 */

@Service
public class BuyFundService {

	private static Logger log = LoggerFactory.getLogger(BuyFundService.class);

	@Autowired
	TradeService tradeService;

	@Autowired
	ChannelService channelService;

	@Autowired
	FundService fundService;

	@Autowired
	HolidayService holidayService;

	@Autowired
	UserVoService userVoService;

	@Autowired
	AccountService accountService;

	@Autowired
	CapitalAllocationService capitalAllocationService;

	@Autowired
	AccountFundAmountService accountFundAmountService;


	/**
	 * 购买基金业务流程 1.记录申购记录trade(需调用节假日获取资金划拨时间)
	 * 2.个人余额账户转入个人冻结账户成功进行3,否则trade状态失败并结束 3.向同花顺发起申购请求成功进行4,否则trade状态失败并结束
	 * 4.同花顺申购成功修改个人基金账户余额信息,trade状态成功并结束
	 * 
	 * @throws Exception
	 */
	@Transactional /* (rollbackFor={Exception.class, RuntimeException.class}) */
	public BuyResultVo buyThs(BuyOrRedeForm buyOrRedeForm) throws Exception {
		// buyOrRedeForm.setTradeNo(CodeBuilder.generatorTradeNo(""));
		BuyResultVo buyResultVo = new BuyResultVo();
		Channel channel = channelService.QueryByCode(buyOrRedeForm.getChannel());
		if (null == channel) {
			buyResultVo.createError("channel.illegal");
			return buyResultVo;
		}
		Account account = accountService.queryAccountByAccountNo(buyOrRedeForm.getAccountNo());
		if (account == null) {
			buyResultVo.createError("account.notFound");
			return buyResultVo;
		}
		Fund fund = fundService.queryByCode(buyOrRedeForm.getFundCode());
		if (fund == null) {
			buyResultVo.createError("fund.notfund");
			return buyResultVo;
		}
		// 获取基金状态

		// 获取用户信息
		UserVo userVo = userVoService.finduserVo(buyOrRedeForm.getAccountNo(), channel.getId());
		// 实例化申购记录
		Trade trade = tradeService.newBuyTrade(buyOrRedeForm.getAmount(), channel, fund, buyOrRedeForm.getTradeNo(),
				userVo.getAccount3RD());
		CapitalAllocation capitalAllocation = new CapitalAllocation();
		capitalAllocation.setAmount(buyOrRedeForm.getAmount());
		capitalAllocation.setOccurTime(new Date());
		// 发送到cbip申请冻结账户
		try {
			capitalAllocation.setTxTradeNo(HttpUtil.cbipFrozen(buyOrRedeForm.getAccountNo(), buyOrRedeForm.getAmount()));
			capitalAllocation.setStatus(true);
		} catch (Exception e) {
			trade.setStatus(Status.FAIL);
			tradeService.insert(trade);
			capitalAllocation.setStatus(false);
			return buyResultVo.createError("fund.buy");
		} finally {
			capitalAllocationService.transferAmount(capitalAllocation);
			capitalAllocation = null;
		}
		capitalAllocation = new CapitalAllocation();
		capitalAllocation.setAmount(buyOrRedeForm.getAmount());
		capitalAllocation.setOccurTime(new Date());
		// 发送同花顺,默认发送到同花顺成功申购之后向cbip发送划账为成功的
		try {
			ThsMcipBuyFundResponseVo thsMcipBuyFundResponseVo = HttpUtil.mcipBuyThs(userVo, buyOrRedeForm);
			trade.setStatus(Status.SUCCESS);
			trade.setExtTradeNo(thsMcipBuyFundResponseVo.getData().getAppsheetSerialNo());
			// 修改个人基金账户余额信息 
			AccountFundAmount accountFundAmount = accountFundAmountService.modifyAccountFundAmount(account.getId(),
					buyOrRedeForm.getAmount(), fund.getChannel().getId(), fund.getId(),true);
			// 调用发起资金划拨从个人冻结账户到同花顺基金账户,如果失败如何处理,需要处理
			capitalAllocation.setStatus(true);
			capitalAllocation.setTxTradeNo(
					HttpUtil.cbipTransfer(buyOrRedeForm.getAccountNo(), channel.getCode().name(), buyOrRedeForm.getAmount(),true));
			buyResultVo.setTotalAmount(accountFundAmount.getAmount());
			buyResultVo.setTradeNo(buyOrRedeForm.getTradeNo());
			buyResultVo.setApplyNo(thsMcipBuyFundResponseVo.getData().getAppsheetSerialNo());
			return buyResultVo;
		} catch (Exception e) {
			// 资金从个人冻结账户转入到余额账户,未记录资金划拨该笔记录
			HttpUtil.cbipUnFrozen(buyOrRedeForm.getAccountNo(), buyOrRedeForm.getAmount());
			trade.setStatus(Status.FAIL);
			capitalAllocation.setStatus(false);
			// 同时记录资金划拨流水
			return buyResultVo.createError("fund.buy");
		} finally {
			tradeService.insert(trade);
			capitalAllocationService.transferAmount(capitalAllocation);
		}

	}

}
