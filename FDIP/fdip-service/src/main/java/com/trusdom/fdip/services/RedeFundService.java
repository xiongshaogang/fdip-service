/**
 * 
 */
package com.trusdom.fdip.services;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trusdom.fdip.common.CodeBuilder;
import com.trusdom.fdip.common.HttpUtil;
import com.trusdom.fdip.form.BuyOrRedeForm;
import com.trusdom.fdip.mappers.SgeditMapper;
import com.trusdom.fdip.model.Account;
import com.trusdom.fdip.model.AccountFundAmount;
import com.trusdom.fdip.model.CapitalAllocation;
import com.trusdom.fdip.model.Channel;
import com.trusdom.fdip.model.Fund;
import com.trusdom.fdip.model.Sgedit;
import com.trusdom.fdip.model.Trade;
import com.trusdom.fdip.model.Trade.Status;
import com.trusdom.fdip.vo.AvaiableAmountVo;
import com.trusdom.fdip.vo.RedeResultVo;
import com.trusdom.fdip.vo.ThsMcipTotalAmountResponseVo;
import com.trusdom.fdip.vo.UserVo;

/**
 * @author zhihuayang E-mail:425273175@qq.com
 * @date 创建时间：2016年5月18日 下午4:27:59
 * @version 1.0
 * @parameter
 * @return
 */
@Service
public class RedeFundService {

	private static Logger log = LoggerFactory.getLogger(RedeFundService.class);

	@Autowired
	SgeditMapper sgeditMapper;

	@Autowired
	ChannelService channelService;
	
	@Autowired
	FundService fundService;

	@Autowired
	AccountService accountService;

	@Autowired
	UserVoService userVoService;

	@Autowired
	AccountFundAmountService accountFundAmountService;

	@Autowired
	TradeService tradeService;
	
	@Autowired
	CapitalAllocationService capitalAllocationService;
	

	/**
	 * 添加修改
	 * 
	 * @param mount
	 * @param tradeId
	 */
	private void addSgedit(BigDecimal mount, Long tradeId) {
		Sgedit sgedit = new Sgedit();
		sgedit.setAmount(mount);
		sgedit.setCreateTime(new Date());
		sgedit.setTrade(tradeId);
		sgeditMapper.add(sgedit);
	}

	/**
	 * 修改份额包装 缺少操作cbip資金劃撥,是一次性劃撥還是多次劃撥,如下使用一笔一笔划拨
	 * 
	 * @param trades
	 * @param mount
	 * @throws Exception
	 */
	private String modifyamount(List<Trade> trades, BigDecimal mount, UserVo userVo,String accountNo, String channel) throws Exception {
		StringBuffer sb = new StringBuffer("");
		for (Trade trade : trades) {
			if (trade.getRealAmount().doubleValue() >= mount.doubleValue()) {
				// 調用同花順修改
				sb.append(HttpUtil.mcipModifyThs(trade.getExtTradeNo(), mount.toString(), userVo.getTradePassword(), userVo.getTransActionAccountId(), userVo.getUserId(), CodeBuilder.generatorTradeNo(null)));
				//调用cbip资金划拨接口
				CapitalAllocation capitalAllocation=new CapitalAllocation();
				capitalAllocation.setAmount(mount);
				capitalAllocation.setOccurTime(new Date());
				try{
					capitalAllocation.setStatus(true);
					capitalAllocation.setTxTradeNo(HttpUtil.cbipTransfer(accountNo, channel, mount,false));
				}
				catch(Exception e){
					capitalAllocation.setStatus(false);
				}
				finally {
					capitalAllocationService.transferAmount(capitalAllocation);
				}
				// 更新trade记录
				tradeService.updateTradeAmount(trade.getRealAmount().subtract(mount), new Date(), trade.getId());
				// 添加修改记录
				addSgedit(mount, trade.getId());
				break;
			} else {
				// 調用同花順修改
				sb.append(HttpUtil.mcipModifyThs(trade.getExtTradeNo(), trade.getRealAmount().toString(), userVo.getTradePassword(),userVo.getTransActionAccountId(),userVo.getUserId(),
						CodeBuilder.generatorTradeNo(null)) + ",");
				mount = mount.subtract(trade.getRealAmount());
				// 更新trade记录
				tradeService.updateTradeAmount(new BigDecimal("0.00"), new Date(), trade.getId());
				// 添加修改记录
				addSgedit(trade.getRealAmount(), trade.getId());
			}
		}
		return sb.toString();
	}



	/**
	 * 赎回规则为可修改份额足够,赎回可修改份额,快速赎回和可修改份额和利息之和是否大于修改份额,足够则两条路并行操作,不够则提示用户可修改份额,未判断最小持有份额
	 * 
	 * @param buyOrRedeForm
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Exception.class, RuntimeException.class })
	public RedeResultVo RedeThs(BuyOrRedeForm buyOrRedeForm) throws Exception {
//		buyOrRedeForm.setTradeNo(CodeBuilder.generatorTradeNo(null));
		// 获取可赎回金额
		RedeResultVo redeFundVo = new RedeResultVo();
		Channel channel = channelService.QueryByCode(buyOrRedeForm.getChannel());
		if (null == channel){
			redeFundVo.createError("channel.illegal");
			return redeFundVo;
		}
		Account account = accountService.queryAccountByAccountNo(buyOrRedeForm.getAccountNo());
		if (account == null) {
			redeFundVo.createError("account.notFound");
			return redeFundVo;
		}
		Fund fund = fundService.queryByCode(buyOrRedeForm.getFundCode());
		if (fund == null) {
			redeFundVo.createError("fund.notfund");
			return redeFundVo;
		}
		AccountFundAmount accountFundAmount = accountFundAmountService.findByAccountAndChannel(account.getId(),
				channel.getId());
		if (accountFundAmount.getAmount().doubleValue() >= buyOrRedeForm.getAmount().doubleValue()) {
			UserVo userVo = userVoService.finduserVo(buyOrRedeForm.getAccountNo(), fund.getChannel().getId());
			Trade redeTrade = tradeService.newRedeTrade(buyOrRedeForm.getAmount(), buyOrRedeForm.getTradeNo(),
					channel, fund, userVo.getAccount3RD());
			List<Trade> trades = tradeService.findTotalmodify(userVo.getAccount3RD(), fund.getId(), new Date());
			BigDecimal canuse = new BigDecimal("0.00");
			for (Trade trade : trades) {
				canuse = canuse.add(trade.getRealAmount());
			}
			// 查看可修改份额是否足够
			if (canuse.doubleValue() >= buyOrRedeForm.getAmount().doubleValue()) {
				try {
					redeTrade.setStatus(Status.SUCCESS);
					redeTrade.setExtTradeNo(modifyamount(trades, buyOrRedeForm.getAmount(), userVo,channel.getCode().name(),buyOrRedeForm.getAccountNo()));
					// 修改余额
					accountFundAmountService.modifyAccountFundAmount(account.getId(), buyOrRedeForm.getAmount(),
							fund.getChannel().getId(), fund.getId(),false);
					redeFundVo.setApplyNo("");
					redeFundVo.setTradeNo(buyOrRedeForm.getTradeNo());
					return redeFundVo;
				} catch (Exception e) {
					redeTrade.setStatus(Status.FAIL);
					return redeFundVo.createError("fund.rede.error");
				}
				finally {
					tradeService.insert(redeTrade);
				}
			}
			// 查看两者之和是否足够,不够抛出异常提示赎回失败
			else {
				try {
					ThsMcipTotalAmountResponseVo thsMcipTotalAmountResponseVo = HttpUtil.mcipGetTotalAmountThs(userVo.getTransActionAccountId(),userVo.getUserId(),
							buyOrRedeForm.getFundCode());
					if (canuse.add(new BigDecimal(thsMcipTotalAmountResponseVo.getData().getConfirmedvol()))
							.compareTo(buyOrRedeForm.getAmount()) >= 0) {
						// 发送快速赎回
						String extfastTradeNo = "";//HttpUtil.mcipFastRedeThs(buyOrRedeForm.getFundCode(), CodeBuilder.generatorTradeNo(""), userVo.getTransActionAccountId(), userVo.getTradePassword(), userVo.getUserId(), userVo.getPhone(), buyOrRedeForm.getAmount().subtract(canuse));
						// 所有的可修改全部发送到同花顺,剩下的金额调用t+0快速赎回
						String extTradeNo = modifyamount(trades, canuse, userVo,channel.getCode().name(),buyOrRedeForm.getAccountNo());
						redeTrade.setStatus(Status.SUCCESS);
						redeTrade.setExtTradeNo(extfastTradeNo+","+extTradeNo);
						accountFundAmountService.modifyAccountFundAmount(account.getId(), buyOrRedeForm.getAmount(),
								fund.getChannel().getId(), fund.getId(),false);
						redeFundVo.setApplyNo("");
						redeFundVo.setTradeNo(buyOrRedeForm.getTradeNo());
						return redeFundVo;
					} else {
						redeTrade.setStatus(Status.FAIL);
						return redeFundVo.createError("fund.amount.than");
					}
				} catch (Exception e) {
					redeTrade.setStatus(Status.FAIL);
					log.error(e.getMessage());
					return redeFundVo.createError("fund.rede.error");
				}
				finally{
					tradeService.insert(redeTrade);
				}
			}
		} else
			return redeFundVo.createError("fund.amount.than");
	}

	/**
	 * 查询可赎回金额
	 * 
	 * @param cardNo
	 * @param fundCode
	 * @return
	 */
	public AvaiableAmountVo findAvaiableAmount(String accountNo, String fundCode) {
		AvaiableAmountVo avaiableAmountVo = new AvaiableAmountVo();
		try {
			Account account = accountService.queryAccountByAccountNo(accountNo);
			if (account == null) {
				avaiableAmountVo.createError("account.notFound");
				return avaiableAmountVo;
			}
			Fund fund = fundService.queryByCode(fundCode);
			if (fund == null) {
				avaiableAmountVo.createError("fund.notfund");
				return avaiableAmountVo;
			}
			UserVo userVo = userVoService.finduserVo(accountNo, fund.getChannel().getId());
			List<Trade> trades = tradeService.findTotalmodify(userVo.getAccount3RD(), fund.getId(), new Date());
			BigDecimal canuse = new BigDecimal("0.00");
			for (Trade trade : trades) {
				canuse = canuse.add(trade.getRealAmount());
			}
			ThsMcipTotalAmountResponseVo thsMcipTotalAmountResponseVo = HttpUtil.mcipGetTotalAmountThs(userVo.getTransActionAccountId(), userVo.getUserId(),fundCode);
			avaiableAmountVo
					.setAmount(canuse.add(new BigDecimal(thsMcipTotalAmountResponseVo.getData().getConfirmedvol())));
			avaiableAmountVo.setFundCode(fundCode);
			avaiableAmountVo.setAccountNo(accountNo);
		} catch (Exception e) {
			log.error(e.getMessage());
			avaiableAmountVo.createError("global.systemError");
		}
		return avaiableAmountVo;
	}

}
