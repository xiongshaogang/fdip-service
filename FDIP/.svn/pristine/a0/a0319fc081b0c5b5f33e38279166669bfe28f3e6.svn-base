/**
 * 
 */
package com.trusdom.fdip.vo;

import java.math.BigDecimal;

/**
 * @author  zhihuayang E-mail:425273175@qq.com 
 * @date 创建时间：2016年6月25日 上午10:34:17
 * @version 1.0 
 * @parameter  
 * @return  
*/
/**
 * @author lenovo
 *
 */
public class TradingVo implements Comparable<TradingVo> {

	private String appSheetSerialNo;

	private String custId;

	private String transActionAccountId;

	private String applicationAmount;

	private String transActionDate;

	private String fundCode;

	private String fundName;

	private String fundType;

	private String taCode;

	public String getAppSheetSerialNo() {
		return appSheetSerialNo;
	}

	public void setAppSheetSerialNo(String appSheetSerialNo) {
		this.appSheetSerialNo = appSheetSerialNo;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getTransActionAccountId() {
		return transActionAccountId;
	}

	public void setTransActionAccountId(String transActionAccountId) {
		this.transActionAccountId = transActionAccountId;
	}

	public String getApplicationAmount() {
		return applicationAmount;
	}

	public void setApplicationAmount(String applicationAmount) {
		this.applicationAmount = applicationAmount;
	}

	public String getTransActionDate() {
		return transActionDate;
	}

	public void setTransActionDate(String transActionDate) {
		this.transActionDate = transActionDate;
	}

	public String getFundCode() {
		return fundCode;
	}

	public void setFundCode(String fundCode) {
		this.fundCode = fundCode;
	}

	public String getFundName() {
		return fundName;
	}

	public void setFundName(String fundName) {
		this.fundName = fundName;
	}

	public String getFundType() {
		return fundType;
	}

	public void setFundType(String fundType) {
		this.fundType = fundType;
	}

	public String getTaCode() {
		return taCode;
	}

	public void setTaCode(String taCode) {
		this.taCode = taCode;
	}

	@Override
	public int compareTo(TradingVo o) {
		// TODO Auto-generated method stub
		return new BigDecimal(o.getApplicationAmount()).compareTo(new BigDecimal(this.applicationAmount));
	}
}
