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
 * @date 创建时间：2016年5月17日 下午3:00:33
 * @version 1.0
 * @parameter
 * @return
 */

public class CapitalAllocation extends BaseCase implements Serializable {

	private Long id;

	private String txTradeNo;
	
	private String tradeNos;

	private BigDecimal amount;

	private Boolean status;
	
	private String type;
	
	private String remark;

	private Date occurTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTxTradeNo() {
		return txTradeNo;
	}

	public void setTxTradeNo(String txTradeNo) {
		this.txTradeNo = txTradeNo;
	}

	public String getTradeNos() {
		return tradeNos;
	}

	public void setTradeNos(String tradeNos) {
		this.tradeNos = tradeNos;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getOccurTime() {
		return occurTime;
	}

	public void setOccurTime(Date occurTime) {
		this.occurTime = occurTime;
	}
	
	public CapitalAllocation(String txTradeNo,BigDecimal amount,Boolean status,Date occurTime ){
		this.txTradeNo=txTradeNo;
		this.amount=amount;
		this.status=status;
		this.occurTime=occurTime;
	}
	public CapitalAllocation(String txTradeNo,String tradeNos,BigDecimal amount,Boolean status,Date occurTime ){
		this.txTradeNo=txTradeNo;
		this.tradeNos=tradeNos;
		this.amount=amount;
		this.status=status;
		this.occurTime=occurTime;
	}
	
	public CapitalAllocation(){
		
	}

}
