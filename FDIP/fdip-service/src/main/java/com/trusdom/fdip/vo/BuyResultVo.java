/**
 * 
 */
package com.trusdom.fdip.vo;

import java.math.BigDecimal;

/**
 * @author  zhihuayang E-mail:425273175@qq.com 
 * @date 创建时间：2016年5月19日 下午4:32:02
 * @version 1.0 
 * @parameter  
 * @return  
*/
/**
 * @author lenovo
 *
 */

public class BuyResultVo extends AbstractVo<BuyResultVo> {

	private String tradeNo;

	private String applyNo;

	private BigDecimal totalAmount;

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public String getApplyNo() {
		return applyNo;
	}

	public void setApplyNo(String applyNo) {
		this.applyNo = applyNo;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}


}
