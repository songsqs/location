package com.mobile.location.server.common.exception;

import com.mobile.location.server.common.util.RES_STATUS;

/**
 * 
 * ProjectException
 * 
 * @author songqingshan
 * @date 2016年7月1日 下午3:41:35
 *
 */
public class ProjectException extends RuntimeException {

	private static final long serialVersionUID = 2195068675053227207L;

	private int errorCode = RES_STATUS.SERVER_UNKONW_ERROR.code;
	
	private String errorMsg = "unknown error";

	public ProjectException() {
		super();
	}

	public ProjectException(String message, int errorCode, String errorMsg) {
		super(message);
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}
	
	public ProjectException(String message, RES_STATUS status) {
		super(message);
		this.errorCode = status.code;
		this.errorMsg = status.msg;
	}
	
	public ProjectException(RES_STATUS status) {
		super(status.name());
		this.errorCode = status.code;
		this.errorMsg = status.msg;
	}


	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
}
