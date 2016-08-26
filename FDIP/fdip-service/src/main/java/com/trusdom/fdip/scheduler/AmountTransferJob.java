/**
 * 
 */
package com.trusdom.fdip.scheduler;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.fasterxml.jackson.databind.JsonNode;
import com.trusdom.fdip.common.Config;
import com.trusdom.fdip.common.Constants;
import com.trusdom.fdip.common.HttpUtil;
import com.trusdom.fdip.common.Json;
import com.trusdom.fdip.common.NotifyMessageUtil;
import com.trusdom.fdip.mappers.ChannelMapper;
import com.trusdom.fdip.mappers.FundMapper;
import com.trusdom.fdip.mappers.TradeMapper;
import com.trusdom.fdip.model.CapitalAllocation;
import com.trusdom.fdip.model.Channel;
import com.trusdom.fdip.services.CapitalAllocationService;
import com.trusdom.fdip.vo.AmountTransferVo;
import com.trusdom.fdip.vo.CbipResponseVo;

/**
 * @author  zhihuayang E-mail:425273175@qq.com 
 * @date 创建时间：2016年6月6日 下午3:03:57
 * @version 1.0 
 * @parameter  
 * @return  
*/
/**
 * @author lenovo
 *
 */
public class AmountTransferJob extends QuartzJobBean{
	
	private static final Logger LOGGER=LoggerFactory.getLogger(AmountTransferJob.class);
	
	
	@Autowired
	TradeMapper tradeMapper;
	
	@Autowired
	FundMapper fundMapper;
	
	@Autowired
	ChannelMapper channelMapper;
	
	@Autowired
	CapitalAllocationService capitalAllocationService;
	
	@Autowired
	NotifyMessageUtil notifyMessageUtil;
	
	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		LOGGER.info("定时任务开始进行根据渠道进行资金划拨");
		List<AmountTransferVo> list=tradeMapper.findTransfer(Constants.SDF_DATE.format(new Date()));
		for(AmountTransferVo amountTransferVo:list){
			Channel channel=channelMapper.findById(amountTransferVo.getChannel());
			boolean success=transfer(channel.getCode().name(),amountTransferVo.getTotal());
			if(success){
//自动提现
//				withdraw(channel.getCode().name(),amountTransferVo.getTotal());
			}
		}
		LOGGER.info("定时任务同花顺资金划拨结束");
	}
	
	
	private  boolean   transfer(String Channel,BigDecimal amount){
		LOGGER.info("正在进行[{}]资金划拨,划拨总金额为[{}]",Channel,amount);
		CapitalAllocation capitalAllocation=new CapitalAllocation();
		capitalAllocation.setOccurTime(new Date());
		capitalAllocation.setAmount(amount);
		capitalAllocation.setType("资金划拨");
		try {
			capitalAllocation.setTxTradeNo(HttpUtil.cbipChannelUnFrozen(Channel, amount));
			capitalAllocation.setStatus(true);
			capitalAllocation.setRemark("");
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			capitalAllocation.setStatus(false);
			capitalAllocation.setRemark("同花顺冻结账户转余额账户失败");
			notifyMessageUtil.sendMessage(1,amount.toPlainString(),new Date().toString());
			return false;
		}
		finally{
			capitalAllocationService.transferAmount(capitalAllocation);
		}
	}
	
	private  void withdraw(String Channel,BigDecimal amount){
		LOGGER.info("正在进行[{}]的账户自动提现,提现金额[{}]",Channel,amount);
			try {
				CapitalAllocation capitalAllocation=new CapitalAllocation();
				capitalAllocation.setTxTradeNo(HttpUtil.cbipWithdraw(amount));
				capitalAllocation.setOccurTime(new Date());
				capitalAllocation.setAmount(amount);
				capitalAllocation.setType("自动提现");
				capitalAllocation.setStatus(true);
				capitalAllocation.setRemark("同花顺自动提现成功");
				capitalAllocationService.transferAmount(capitalAllocation);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				LOGGER.info("正在进行[{}]的账户自动提现,提现失败",Channel);
				notifyMessageUtil.sendMessage(2,amount.toPlainString(),new Date().toString());
			}
		}
	
	
}
