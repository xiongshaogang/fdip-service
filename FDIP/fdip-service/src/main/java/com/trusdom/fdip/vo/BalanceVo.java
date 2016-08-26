package com.trusdom.fdip.vo;

import java.math.BigDecimal;

public class BalanceVo extends BaseVo {

	private BigDecimal balance = new BigDecimal(0);
	
	private BigDecimal redeemable = new BigDecimal(0);
	
	private BigDecimal maxRedeemable = new BigDecimal(0);

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public BigDecimal getRedeemable() {
		return redeemable;
	}

	public void setRedeemable(BigDecimal redeemable) {
		this.redeemable = redeemable;
	}

	public BigDecimal getMaxRedeemable() {
		return maxRedeemable;
	}

	public void setMaxRedeemable(BigDecimal maxRedeemable) {
		this.maxRedeemable = maxRedeemable;
	}
	
	
}
