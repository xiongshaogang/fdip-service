package com.trusdom.fdip.model;

import java.math.BigDecimal;
import java.util.Date;

import com.trusdom.fdip.common.Json;

public class Income {

	private long id;
	
	private long channel;
	
	private long fund;
	
	private long account;
	
	private String day;
	
	private BigDecimal income;
	
	private BigDecimal realIncome;
	
	private BigDecimal interestAmount;
	
	private Date createTime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public long getAccount() {
		return account;
	}

	public void setAccount(long account) {
		this.account = account;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public BigDecimal getIncome() {
		return income;
	}

	public void setIncome(BigDecimal income) {
		this.income = income;
	}

	public BigDecimal getRealIncome() {
		return realIncome;
	}

	public void setRealIncome(BigDecimal realIncome) {
		this.realIncome = realIncome;
	}

	public BigDecimal getInterestAmount() {
		return interestAmount;
	}

	public void setInterestAmount(BigDecimal interestAmount) {
		this.interestAmount = interestAmount;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return Json.toJson(this).toString();
	}
}
