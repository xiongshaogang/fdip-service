package com.trusdom.fdip.form;

import org.hibernate.validator.constraints.NotBlank;

import com.trusdom.fdip.common.Json;

public class BaseForm {
	
	@NotBlank(message="渠道编码不能为空; 可取值'THS'")
	private String channel;
	
	@NotBlank(message="基金代码不能为空")
	private String fundCode;

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getFundCode() {
		return fundCode;
	}

	public void setFundCode(String fundCode) {
		this.fundCode = fundCode;
	}

	@Override
	public String toString() {
		return Json.toJson(this).toString();
	}
	
}
