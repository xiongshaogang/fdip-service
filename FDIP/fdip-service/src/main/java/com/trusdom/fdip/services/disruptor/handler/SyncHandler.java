package com.trusdom.fdip.services.disruptor.handler;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lmax.disruptor.EventHandler;
import com.trusdom.fdip.common.BeanUtils;
import com.trusdom.fdip.model.Income;
import com.trusdom.fdip.services.disruptor.event.IncomeSyncEvent;

public class SyncHandler implements EventHandler<IncomeSyncEvent>{

	private static final Logger LOGGER = LoggerFactory.getLogger(SyncHandler.class);
	@Override
	public void onEvent(IncomeSyncEvent event, long sequence, boolean endOfBatch) throws Exception {
		LOGGER.info("开始同步用户收益数据");
		System.err.println(event.getAccount()+"=="+event.getChannel()+"=="+event.getFund());
		System.err.println(event.getIncomeMapper().findMyIncomeByDay(event.getAccount(), event.getChannel(), event.getFund(), "2016-05-10"));
		Income income = new Income();
		BeanUtils.copyProperties(event, income);
		income.setCreateTime(new Date());
		event.getIncomeMapper().save(income);
	}
}
