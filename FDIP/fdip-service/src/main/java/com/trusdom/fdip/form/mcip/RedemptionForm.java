package com.trusdom.fdip.form.mcip;

import com.trusdom.fdip.common.Json;

public class RedemptionForm {
	private String transActionAccountId;
	private String shareType;
	private String fundCode;
	private String tradePassword;
	private String money;
	private String largeRedemptionSelect = "1";
	private String mobileTelNo;
	private String userid;
	public String getTransActionAccountId() {
		return transActionAccountId;
	}
	public void setTransActionAccountId(String transActionAccountId) {
		this.transActionAccountId = transActionAccountId;
	}
	public String getShareType() {
		return shareType;
	}
	public void setShareType(String shareType) {
		this.shareType = shareType;
	}
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
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getLargeRedemptionSelect() {
		return largeRedemptionSelect;
	}
	public void setLargeRedemptionSelect(String largeRedemptionSelect) {
		this.largeRedemptionSelect = largeRedemptionSelect;
	}
	public String getMobileTelNo() {
		return mobileTelNo;
	}
	public void setMobileTelNo(String mobileTelNo) {
		this.mobileTelNo = mobileTelNo;
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
