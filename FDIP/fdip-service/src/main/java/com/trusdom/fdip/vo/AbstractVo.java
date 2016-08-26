package com.trusdom.fdip.vo;

import java.io.Serializable;

import com.fasterxml.jackson.databind.JsonNode;
import com.trusdom.fdip.common.ErrorCode;
import com.trusdom.fdip.common.Json;


/**
 * 
* @ClassName: AbstractVo 
* @Description: TODO(***)
* @author zjb 
* @date May 16, 2016 5:52:31 PM
* 
* @param <T>
 */
public abstract class AbstractVo<T extends AbstractVo> {
	
	protected Boolean success = true;
	
	protected String errCode = "";
	
	protected String errMsg = "";

	public Boolean isSuccess(){
		return success;
	}
	
	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public T createError(String errKey){
		this.success = false;
		this.errCode = ErrorCode.getErrorCode(errKey);
		this.errMsg = ErrorCode.getErrorMsg(errKey);
		return (T)this;
	}
	@Override
	public String toString() {
		return toJson().toString();
	}
	
	public JsonNode toJson(){
		return Json.toJson(this);
	}
}
