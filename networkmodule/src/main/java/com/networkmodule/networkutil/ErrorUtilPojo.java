package com.networkmodule.networkutil;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ErrorUtilPojo {
	@SerializedName("status")
	@Expose
	private Boolean status;
	@SerializedName("result_code")
	@Expose
	private Integer resultCode;
	@SerializedName("message")
	@Expose
	private String message;

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Integer getResultCode() {
		return resultCode;
	}

	public void setResultCode(Integer resultCode) {
		this.resultCode = resultCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
