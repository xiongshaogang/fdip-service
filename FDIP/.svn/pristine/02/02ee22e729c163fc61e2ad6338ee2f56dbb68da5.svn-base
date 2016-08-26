package com.trusdom.fdip.services;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trusdom.fdip.common.Json;
import com.trusdom.fdip.model.Account;
import com.trusdom.fdip.model.Account3RD;
import com.trusdom.fdip.model.CapitalAllocation;
import com.trusdom.fdip.model.Trade;
import com.trusdom.fdip.model.Trade.Status;
import com.trusdom.fdip.model.account3RD.ThsAccount;
import com.trusdom.fdip.vo.BaseVo;
import com.trusdom.fdip.vo.CapitalTransferVo;

@Service
public class CommonService {

	@Autowired
	TradeService tradeService;

	@Autowired
	AccountService accountService;

	@Autowired
	Account3RDService account3RDsService;

	@Autowired
	CapitalAllocationService capitalAllocationService;

	public BaseVo capitalTransferQuery(String tradeNo) {
		Trade trade = tradeService.findByTradeNo(tradeNo);
		if (null != trade) {
			CapitalTransferVo result = new CapitalTransferVo();
			result.setStatus(!trade.getStatus().equals(Status.FAIL));
			result.setAmount(trade.getRealAmount());
			result.setApplyNo(trade.getExtTradeNo());
			result.setTransferNo(trade.getTransferNo());
			Account account = trade.getAccount();
			result.setName(account.getName());
			result.setBankAccountNo(account.getBankAccount());
			result.setCredential(account.getCredential());
			Account3RD account3RD = account3RDsService.findById(trade.getThrdAccount());
			ThsAccount thsAccount = Json.fromJson(Json.parse(account3RD.getAccountInfo()), ThsAccount.class);
			result.setTransActionAccount(thsAccount.getTransActionAccountId());
			Calendar cal = Calendar.getInstance();
			cal.setTime(trade.getCreateTime());
			result.setOccurTime(cal.getTimeInMillis() / 1000);
			return result;
		} else {
			BaseVo baseVo = new BaseVo();
			baseVo.createError("global.resourceNotFound");
			return baseVo;
		}
	}
}
