package com.trusdom.fdip.model.verify;

import java.util.Date;

import com.trusdom.fdip.common.Json;
import com.trusdom.fdip.model.Account;
import com.trusdom.fdip.model.Account3RD;
import com.trusdom.fdip.model.Channel;
import com.trusdom.fdip.model.Fund;

public class Verify {

	private Account account;
	
	private Account3RD account3RD;
	
	private Channel channel;
	
	private Fund fund;
	
	private String day;
	
	private String src;
	
	private String local;
	
	private Boolean verify;
	
	private String verifyFile;
	
	private Date creatTime;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Account3RD getAccount3RD() {
		return account3RD;
	}

	public void setAccount3RD(Account3RD account3rd) {
		account3RD = account3rd;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public Fund getFund() {
		return fund;
	}

	public void setFund(Fund fund) {
		this.fund = fund;
	}

	public String getDay() {
		return day;
	}


	public void setDay(String day) {
		this.day = day;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}


	public Boolean getVerify() {
		return verify;
	}

	public void setVerify(Boolean verify) {
		this.verify = verify;
	}

	public String getVerifyFile() {
		return verifyFile;
	}

	public void setVerifyFile(String verifyFile) {
		this.verifyFile = verifyFile;
	}

	public Date getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}

	@Override
	public String toString() {
		return Json.toJson(this).toString();
	}
	
}
