/**
 * 
 */
package com.trusdom.fdip.vo;

import java.math.BigDecimal;

import com.trusdom.fdip.common.BaseCase;

/**
 * @author  zhihuayang E-mail:425273175@qq.com 
 * @date 创建时间：2016年7月27日 下午5:08:56
 * @version 1.0 
 * @parameter  
 * @return  
*/
/**
 * @author lenovo
 *
 */
public class CbipWithdrawRequestVo extends BaseCase{
	
	private BigDecimal amount;

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	
}
