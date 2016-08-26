/**
 * 
 */
package com.trusdom.fdip.model;

import java.io.Serializable;
import java.util.Date;

import com.trusdom.fdip.common.Json;

/**
 * @author zhihuayang E-mail:425273175@qq.com
 * @date 创建时间：2016年5月6日 下午5:03:58
 * @version 1.0
 * @parameter
 * @return
 */

public class Account implements Serializable {
	
	public enum Status{
		ENABLE, DISABLE
	}
	
	private Long id;
	private String accountNo;				//摊位号
	private String bankAccountNo;			//银行子账号
	private String bankAccount;             //银行卡号
	private String name;
	private String credential;
	private String tradePwd;				//交易密码
	private Date createTime;
	private Date updateTime;
	private Status status = Status.ENABLE;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getBankAccountNo() {
		return bankAccountNo;
	}
	public void setBankAccountNo(String bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
	}
	public String getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCredential() {
		return credential;
	}
	public void setCredential(String credential) {
		this.credential = credential;
	}
	public String getTradePwd() {
		return tradePwd;
	}
	public void setTradePwd(String tradePwd) {
		this.tradePwd = tradePwd;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	@Override
	public String toString() {
		return Json.toJson(this).toString();
	}
	
}
