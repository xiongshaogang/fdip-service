/**
 * 
 */
package com.trusdom.fdip.model;

import java.io.Serializable;

import com.trusdom.fdip.common.Json;

/**
 * @author zhihuayang E-mail:425273175@qq.com
 * @date 创建时间：2016年5月10日 下午5:14:48
 * @version 1.0
 * @parameter
 * @return
 */

public class BuyFound implements Serializable {


	private Long id;

	private String userid;// 基金账户id

	private Long time;// 申购时间

	private double mount;// 申购金额

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public double getMount() {
		return mount;
	}

	public void setMount(double mount) {
		this.mount = mount;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return Json.toJson(this).toString();
	}

}
