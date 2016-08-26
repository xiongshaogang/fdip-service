package com.trusdom.fdip.services.disruptor.handler;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lmax.disruptor.EventHandler;
import com.trusdom.fdip.common.HttpUtil;
import com.trusdom.fdip.services.disruptor.event.IncomeSyncEvent;

public class AmountHandler implements EventHandler<IncomeSyncEvent>{

	private static final Logger LOGGER = LoggerFactory.getLogger(AmountHandler.class);
	
	private static final int INDEX1 = 1;
	@Override
	public void onEvent(IncomeSyncEvent event, long sequence, boolean endOfBatch)
			throws Exception {
		LOGGER.debug("开始同步用户{}|{}的计息份额", event.getAccount(), event.getAccount3rd());
//		String result = HttpUtil.sendRequest("url", false, "GET", "", false);
//		LOGGER.info("用户计息份额:{}", result);
		event.output[INDEX1] = new BigDecimal(event.getAccount());
		event.interestAmount = new BigDecimal(event.getAccount());
		LOGGER.debug("同步完成");
	}
}
