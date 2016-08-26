package com.trusdom.fdip.services.disruptor.event;

import java.util.Calendar;

import com.lmax.disruptor.EventFactory;
import com.trusdom.fdip.common.Constants;

public class IncomeRateSyncEvent {

	private String fundCode;
	
	private String day;

	public String getFundCode() {
		return fundCode;
	}

	public void setFundCode(String fundCode) {
		this.fundCode = fundCode;
	}

	public String getDay() {
		if (null == this.day){
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, -1);
			return Constants.SDF_DATE.format(cal.getTime()); 
		}
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public static final EventFactory<IncomeRateSyncEvent> INCOMERATE_SYNC_EVENT_FACTORY = new EventFactory<IncomeRateSyncEvent>() {
		@Override
		public IncomeRateSyncEvent newInstance() {
			return new IncomeRateSyncEvent();
		}
	};
	
}
