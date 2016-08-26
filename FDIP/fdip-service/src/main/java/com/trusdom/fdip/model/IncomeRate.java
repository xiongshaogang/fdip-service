package com.trusdom.fdip.model;

import java.math.BigDecimal;
import java.util.Date;

import com.trusdom.fdip.common.Json;

public class IncomeRate {

	private long id;
	
	private long channel;
	
	private long fund;
	
	private String day;
	
	private BigDecimal millionIncomeRate;
	
	private BigDecimal annualIncome7d;
	
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

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public BigDecimal getMillionIncomeRate() {
		return millionIncomeRate;
	}

	public void setMillionIncomeRate(BigDecimal millionIncomeRate) {
		this.millionIncomeRate = millionIncomeRate;
	}

	public BigDecimal getAnnualIncome7d() {
		return annualIncome7d;
	}

	public void setAnnualIncome7d(BigDecimal annualIncome7d) {
		this.annualIncome7d = annualIncome7d;
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
