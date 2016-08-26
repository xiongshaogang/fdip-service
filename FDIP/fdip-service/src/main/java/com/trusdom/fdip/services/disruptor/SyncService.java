package com.trusdom.fdip.services.disruptor;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trusdom.fdip.common.Constants;
import com.trusdom.fdip.common.DateUtil;
import com.trusdom.fdip.common.Json;
import com.trusdom.fdip.mappers.AccountFundAmountMapper;
import com.trusdom.fdip.mappers.IncomeMapper;
import com.trusdom.fdip.model.Account3RD;
import com.trusdom.fdip.model.Channel;
import com.trusdom.fdip.model.Channel.Code;
import com.trusdom.fdip.model.Fund;
import com.trusdom.fdip.model.account3RD.ThsAccount;
import com.trusdom.fdip.services.IncomeService;
import com.trusdom.fdip.services.disruptor.event.IncomeSyncEvent;
import com.trusdom.fdip.services.mcip.McipThsFundService;
import com.trusdom.fdip.spring.configs.AppConfig;

@Service
public class SyncService {

	@Autowired
	IncomeMapper incomeMapper;
	@Autowired
	AccountFundAmountMapper accountFundAmountMapper;
	@Autowired
	McipThsFundService mcipThsFundService;
	@Autowired
	IncomeService incomeService;
	public void sync(Account3RD account3rd, Fund fund){
		long sequence = AppConfig.ringBuffer.next();
		try{
			IncomeSyncEvent event = AppConfig.ringBuffer.get(sequence);
			event.setAccount(account3rd.getAccount().getId());
			Channel channel = account3rd.getChannel();
			event.setChannel(channel.getId());
			Code channelCode = channel.getCode();
			switch (channelCode) {
			case THS:
				ThsAccount thsAccount = Json.fromJson(Json.parse(account3rd.getAccountInfo()), ThsAccount.class);
				event.setAccount3rd(thsAccount.getCustId());
				event.setTransferAccount3rd(thsAccount.getTransActionAccountId());
				break;
			default:
				break;
			}
			event.setFundCode(fund.getCode());
			event.setFund(fund.getId());
			event.setIncomeMapper(incomeMapper);
			event.setAccountFundAmountMapper(accountFundAmountMapper);
			event.setMcipThsFundService(mcipThsFundService);
			event.setIncomeService(incomeService);
			event.setDay(DateUtil.yestoday(Constants._SDF_DATE));
		}finally {
			AppConfig.ringBuffer.publish(sequence);
		}
	}
}
