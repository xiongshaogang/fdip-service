/**
 * 
 */
package com.trusdom.fdip.model;

import java.io.Serializable;

import com.trusdom.fdip.common.Json;

/**
 * @author zhihuayang E-mail:425273175@qq.com
 * @date 创建时间：2016年5月10日 下午5:22:38
 * @version 1.0
 * @parameter
 * @return
 */

public class RedeFound implements Serializable {

	private Long id;

	private String userid;// 基金账户id

	private Long time;// 赎回时间

	private double mount;// 赎回金额

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
