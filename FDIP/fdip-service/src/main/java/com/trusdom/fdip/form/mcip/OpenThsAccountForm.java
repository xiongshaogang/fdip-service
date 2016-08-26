package com.trusdom.fdip.form.mcip;

import org.apache.commons.codec.digest.DigestUtils;
import org.eclipse.jetty.util.security.Credential.MD5;

import com.trusdom.fdip.common.CodeBuilder;
import com.trusdom.fdip.common.Json;
import com.trusdom.fdip.form.AccountForm;


/**
 * 开户
 * Author: ChenPeng
 * Time:  2016/5/17 11:26.
 */
public class OpenThsAccountForm{
    private String bankAccountName;         //银行账户名
    private String identityTypeInBank;      //证件类型
    private String identityNoInBank;        //证件号码
    private String emailAddress;            //邮件地址
    private String bankCode;                //银行代码
    private String bankName;                //银行名字
    private String bankAccount;             //银行卡号
    private String tradePassword;           //交易密码
    private String branchProvince;          //省
    private String branchCity;              //市
    private String thsBranchCode;           //同花顺联行号标志
    private String bankMP;                  //手机号
    private String txTraceNo;               //请求流水号

    public String getBankAccountName() {
        return bankAccountName;
    }

    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName;
    }

    public String getIdentityTypeInBank() {
        return identityTypeInBank;
    }

    public void setIdentityTypeInBank(String identityTypeInBank) {
        this.identityTypeInBank = identityTypeInBank;
    }

    public String getIdentityNoInBank() {
        return identityNoInBank;
    }

    public void setIdentityNoInBank(String identityNoInBank) {
        this.identityNoInBank = identityNoInBank;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getTradePassword() {
        return tradePassword;
    }

    public void setTradePassword(String tradePassword) {
        this.tradePassword = tradePassword;
    }

    public String getBranchProvince() {
        return branchProvince;
    }

    public void setBranchProvince(String branchProvince) {
        this.branchProvince = branchProvince;
    }

    public String getBranchCity() {
        return branchCity;
    }

    public void setBranchCity(String branchCity) {
        this.branchCity = branchCity;
    }

    public String getThsBranchCode() {
        return thsBranchCode;
    }

    public void setThsBranchCode(String thsBranchCode) {
        this.thsBranchCode = thsBranchCode;
    }

    public String getBankMP() {
        return bankMP;
    }

    public void setBankMP(String bankMP) {
        this.bankMP = bankMP;
    }

    public String getTxTraceNo() {
        return txTraceNo;
    }

    public void setTxTraceNo(String txTraceNo) {
        this.txTraceNo = txTraceNo;
    }
    
    
    @Override
	public String toString() {
		return Json.toJson(this).toString();
	}

	public static OpenThsAccountForm from(AccountForm accountForm){
    	OpenThsAccountForm form = new OpenThsAccountForm();
    	form.setBankAccount(accountForm.getBankAccount());
    	form.setBankAccountName(accountForm.getBankAccountName());
    	form.setBankCode(accountForm.getBankCode());
    	form.setBankMP(accountForm.getPhone());
    	form.setBankName(accountForm.getBankName());
    	form.setBranchCity(accountForm.getCity());
    	form.setBranchProvince(accountForm.getProvince());
    	form.setEmailAddress(accountForm.getEmail());
    	form.setIdentityNoInBank(accountForm.getIdentityNo());
    	form.setIdentityTypeInBank(accountForm.getIdentityType());
    	form.setThsBranchCode(accountForm.getThsBranchCode());
    	form.setTradePassword(DigestUtils.md5Hex(accountForm.getAccountNo()));
    	form.setTxTraceNo(CodeBuilder.generatorTradeNo(accountForm.getChannel()));
    	return form;
    }

}
