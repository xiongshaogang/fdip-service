/**
 * 
 */
package com.trusdom.fdip.vo;

import java.math.BigDecimal;

/**
 * @author  zhihuayang E-mail:425273175@qq.com 
 * @date 创建时间：2016年6月22日 下午4:13:24
 * @version 1.0 
 * @parameter  
 * @return  
*/
/**
 * @author lenovo
 *
 */
public class CbipTransferRequestVo {
	
	public enum TradeType{
		REFUND,TRANSFER
	}
	private String accountNo;
	
	private String channel;
	
	private BigDecimal amount;
	
	private TradeType transferType;
	
	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public TradeType getTransferType() {
		return transferType;
	}

	public void setTransferType(TradeType transferType) {
		this.transferType = transferType;
	}

}
