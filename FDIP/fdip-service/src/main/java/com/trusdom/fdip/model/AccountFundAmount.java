/**
 * 
 */
package com.trusdom.fdip.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.trusdom.fdip.common.BaseCase;

/**
 * @author zhihuayang E-mail:425273175@qq.com
 * @date 创建时间：2016年5月18日 上午10:44:34
 * @version 1.0
 * @parameter
 * @return
 */

public class AccountFundAmount extends BaseCase implements Serializable {

	private static final long serialVersionUID = 2210184332638350378L;

	private Long id;

	private Long channel;

	private Long fund;

	private Long account;

	private BigDecimal amount;//进行中金额
	
	private BigDecimal interestAmount;//计息份额
	
	private BigDecimal frozenAmount;//冻结金额

	private BigDecimal income;//累计收益

	private Date createTime;
	
	private String  incomeTime;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getChannel() {
		return channel;
	}

	public void setChannel(Long channel) {
		this.channel = channel;
	}

	public Long getFund() {
		return fund;
	}

	public void setFund(Long fund) {
		this.fund = fund;
	}

	public Long getAccount() {
		return account;
	}

	public void setAccount(Long account) {
		this.account = account;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getInterestAmount() {
		return interestAmount;
	}

	public void setInterestAmount(BigDecimal interestAmount) {
		this.interestAmount = interestAmount;
	}

	public BigDecimal getIncome() {
		return income;
	}

	public void setIncome(BigDecimal income) {
		this.income = income;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public BigDecimal getFrozenAmount() {
		return frozenAmount;
	}

	public void setFrozenAmount(BigDecimal frozenAmount) {
		this.frozenAmount = frozenAmount;
	}

	public String getIncomeTime() {
		return incomeTime;
	}

	public void setIncomeTime(String incomeTime) {
		this.incomeTime = incomeTime;
	}

}