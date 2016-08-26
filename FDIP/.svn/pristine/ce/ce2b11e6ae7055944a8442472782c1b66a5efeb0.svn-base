package com.trusdom.fdip.services.disruptor.event;

import java.math.BigDecimal;
import java.util.Calendar;

import com.lmax.disruptor.EventFactory;
import com.trusdom.fdip.common.Constants;
import com.trusdom.fdip.mappers.AccountFundAmountMapper;
import com.trusdom.fdip.mappers.IncomeMapper;
import com.trusdom.fdip.services.IncomeService;
import com.trusdom.fdip.services.mcip.McipThsFundService;

public class IncomeSyncEvent {

	private IncomeMapper incomeMapper;
	
	private AccountFundAmountMapper accountFundAmountMapper;
	
	private McipThsFundService mcipThsFundService;
	
	private IncomeService incomeService;
	
	private long account;
	
	private long channel;
	
	private long fund;
	
	private String fundCode;
	
	private String account3rd;
	
	private String transferAccount3rd;
	
	private String day;
	
	public BigDecimal income;
	
	public BigDecimal interestAmount;
	
	public BigDecimal[] output;

	public IncomeMapper getIncomeMapper() {
		return incomeMapper;
	}

	public void setIncomeMapper(IncomeMapper incomeMapper) {
		this.incomeMapper = incomeMapper;
	}

	public AccountFundAmountMapper getAccountFundAmountMapper() {
		return accountFundAmountMapper;
	}

	public void setAccountFundAmountMapper(
			AccountFundAmountMapper accountFundAmountMapper) {
		this.accountFundAmountMapper = accountFundAmountMapper;
	}

	public McipThsFundService getMcipThsFundService() {
		return mcipThsFundService;
	}

	public void setMcipThsFundService(McipThsFundService mcipThsFundService) {
		this.mcipThsFundService = mcipThsFundService;
	}

	public IncomeService getIncomeService() {
		return incomeService;
	}

	public void setIncomeService(IncomeService incomeService) {
		this.incomeService = incomeService;
	}

	public long getAccount() {
		return account;
	}

	public void setAccount(long account) {
		this.account = account;
	}

	public long getChannel() {
		return channel;
	}

	public void setChannel(long channel) {
		this.channel = channel;
	}

	public long getFund() {
		return fund;
	}

	public void setFund(long fund) {
		this.fund = fund;
	}

	public String getFundCode() {
		return fundCode;
	}

	public void setFundCode(String fundCode) {
		this.fundCode = fundCode;
	}

	public String getAccount3rd() {
		return account3rd;
	}

	public void setAccount3rd(String account3rd) {
		this.account3rd = account3rd;
	}

	public String getTransferAccount3rd() {
		return transferAccount3rd;
	}

	public void setTransferAccount3rd(String transferAccount3rd) {
		this.transferAccount3rd = transferAccount3rd;
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
	
	public BigDecimal[] getOutput() {
		return output;
	}

	public void setOutput(BigDecimal[] output) {
		this.output = output;
	}

	public BigDecimal getIncome() {
		return income;
	}

	public void setIncome(BigDecimal income) {
		this.income = income;
	}

	public BigDecimal getInterestAmount() {
		return interestAmount;
	}

	public void setInterestAmount(BigDecimal interestAmount) {
		this.interestAmount = interestAmount;
	}

	public IncomeSyncEvent(int size){
		output = new BigDecimal[size];
	}
	public static final EventFactory<IncomeSyncEvent> INCOME_SYNC_EVENT_FACTORY = new EventFactory<IncomeSyncEvent>() {
		@Override
		public IncomeSyncEvent newInstance() {
			//分别处理昨日收益,总计息份额
			return new IncomeSyncEvent(2);
		}
	};
}

