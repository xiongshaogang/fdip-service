package com.trusdom.fdip.form;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

public class IncomeRateForm extends BaseForm {

	@Pattern(regexp="^((?:19|20)\\d\\d)-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$", message="非法的日期格式")
	@NotBlank(message="起始时间不能为空")
	private String startTime;
	
	@Pattern(regexp="^((?:19|20)\\d\\d)-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$", message="非法的日期格式")
	@NotBlank(message="结束时间不能为空")
	private String endTime;

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	
}
