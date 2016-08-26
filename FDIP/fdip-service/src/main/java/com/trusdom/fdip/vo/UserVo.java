/**
 * 
 */
package com.trusdom.fdip.vo;

import java.io.Serializable;

/**
 * @author  zhihuayang E-mail:425273175@qq.com 
 * @date 创建时间：2016年5月17日 下午12:02:55
 * @version 1.0 
 * @parameter  
 * @return  
 * 用來保存用戶操作基金的對象緩存
*/

public class UserVo implements Serializable {

	private static final long serialVersionUID = -3800729275054375614L;

	private String tradePassword;

	private String transActionAccountId;

	private String userId;
	
	private Long Account3RD;
	
	private String phone;
	

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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Long getAccount3RD() {
		return Account3RD;
	}

	public void setAccount3RD(Long account3rd) {
		Account3RD = account3rd;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
