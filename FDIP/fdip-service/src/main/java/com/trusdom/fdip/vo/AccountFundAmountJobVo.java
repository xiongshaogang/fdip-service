/**
 * 
 */
package com.trusdom.fdip.vo;

import java.math.BigDecimal;

/**
 * @author  zhihuayang E-mail:425273175@qq.com 
 * @date 创建时间：2016年6月30日 下午7:40:56
 * @version 1.0 
 * @parameter  
 * @return  
*/
/**
 * @author lenovo
 *
 */
public class AccountFundAmountJobVo {

	private Long account;

	private Long channel;

	private Long fund;

	private BigDecimal amount;

	public Long getAccount() {
		return account;
	}

	public void setAccount(Long account) {
		this.account = account;
	}

	public Long getChannel() {
		return channel;
	}

	public void setChannel(Long channel) {
		this.channel = channel;
	}

	public Long getFund() {
		return fund;
	}

	public void setFund(Long fund) {
		this.fund = fund;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}
