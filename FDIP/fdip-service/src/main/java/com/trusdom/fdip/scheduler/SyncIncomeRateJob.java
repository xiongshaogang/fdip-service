package com.trusdom.fdip.scheduler;

import java.util.List;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.trusdom.fdip.common.Constants;
import com.trusdom.fdip.common.DateUtil;
import com.trusdom.fdip.model.Channel;
import com.trusdom.fdip.model.Channel.Code;
import com.trusdom.fdip.model.Fund;
import com.trusdom.fdip.services.ChannelService;
import com.trusdom.fdip.services.FundService;
import com.trusdom.fdip.services.HolidayService;
import com.trusdom.fdip.services.IncomeRateService;
import com.trusdom.fdip.services.mcip.McipThsFundService;

public class SyncIncomeRateJob extends QuartzJobBean {
	private static final Logger LOGGER = LoggerFactory.getLogger(SyncIncomeRateJob.class);
	private static final Code CHANNEL = Code.THS;
	@Autowired
	ChannelService channelService;
	
	@Autowired
	FundService fundService;
	
	@Autowired
	IncomeRateService incomeRateService;
	
	@Autowired
	McipThsFundService mcipThsFundService;
	
	@Autowired
	HolidayService holidayService;
	@Override
	protected void executeInternal(JobExecutionContext paramJobExecutionContext)
			throws JobExecutionException {
		LOGGER.info("定时任务: 正在同步基金万份收益率/七日年化收益率...");
		Channel channel = channelService.QueryByCode(CHANNEL.name());
		List<Fund> funds = fundService.queryByChannel(channel);
		for (Fund fund : funds) {
//			syncFundStatus(fund);
			LOGGER.info("开始同步基金[{}|{}]的万份收益率/七日年化", fund.getName(), fund.getCode());
			String yestoday = DateUtil.yestoday(Constants._SDF_DATE);
//			if (holidayService.isWorkday(yestoday)) {
//				syncFundIncomeRate(fund, Constants._SDF_DATE.format(yestoday));
//				yestoday = DateUtil.prevDay(yestoday);
//				if (!holidayService.isWorkday(yestoday)) {
//					syncFundIncomeRate(fund, Constants._SDF_DATE.format(yestoday));
//				}	
//			}
//			else {
//				if(holidayService.isWorkday(DateUtil.prevDay(yestoday))){
//					syncFundIncomeRate(fund, Constants._SDF_DATE.format(yestoday));
//				}
//			}
			/**
			 * 获取上一日和上上日的七日
			 */
//			syncFundIncomeRate(fund, Constants._SDF_DATE.format(yestoday));
//			syncFundIncomeRate(fund, Constants._SDF_DATE.format(DateUtil.prevDay(yestoday)));
			syncFundIncomeRate(fund, yestoday);
			syncFundIncomeRate(fund, DateUtil.prevDay(yestoday, Constants._SDF_DATE));
			LOGGER.info("基金[{}|{}]的万份收益率/七日年化同步完成", fund.getName(), fund.getCode());
		}
		LOGGER.info("定时任务: 同步基金万份收益率/七日年化收益率完成");
	}

	/**
	 * 同步基金状态
	 * @param fund
	 */
	private void syncFundStatus(Fund fund){
		mcipThsFundService.fundStatus(fund);
		fundService.update(fund);
	}
	
	/**
	 * 同步基金万份收益/七日年化
	 * @param fund
	 */
	private void syncFundIncomeRate(Fund fund, String day){
		incomeRateService.addIncomeRate(fund.getCode(), day);
	}
	
	
	
}
