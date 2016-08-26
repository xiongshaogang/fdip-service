package com.trusdom.fdip.form.mcip;

import com.trusdom.fdip.common.Json;

public class PurcharseForm {
	private String fundCode;
	private String tradePassword;
	private String transActionAccountId;
	private String supportShareType = "0";
	private String money;
	private String txTraceNo;
	private String userid;
	public String getFundCode() {
		return fundCode;
	}
	public void setFundCode(String fundCode) {
		this.fundCode = fundCode;
	}
	public String getTradePassword() {
		return tradePassword;
	}
	public void setTradePassword(String tradePassword) {
		this.tradePassword = tradePassword;
	}
	public String getTransActionAccountId() {
		return transActionAccountId;
	}
	public void setTransActionAccountId(String transActionAccountId) {
		this.transActionAccountId = transActionAccountId;
	}
	public String getSupportShareType() {
		return supportShareType;
	}
	public void setSupportShareType(String supportShareType) {
		this.supportShareType = supportShareType;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getTxTraceNo() {
		return txTraceNo;
	}
	public void setTxTraceNo(String txTraceNo) {
		this.txTraceNo = txTraceNo;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	@Override
	public String toString() {
		return Json.toJson(this).toString();
	}
	
}
