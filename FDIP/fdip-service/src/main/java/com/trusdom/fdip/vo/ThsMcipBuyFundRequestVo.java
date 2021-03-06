/**
 * 
 */
package com.trusdom.fdip.vo;

import java.math.BigDecimal;

import com.trusdom.fdip.common.BaseCase;
import com.trusdom.fdip.common.Json;

/**
 * @author  zhihuayang E-mail:425273175@qq.com 
 * @date 创建时间：2016年6月2日 下午2:38:31
 * @version 1.0 
 * @parameter  
 * @return  
*/
/**
 * @author lenovo
 *
 */
public class ThsMcipBuyFundRequestVo extends BaseCase{
	
	private String fundCode;

	private String tradePassword;

	private String transActionAccountId;

	private String supportShareType="0";

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
	
	
}
