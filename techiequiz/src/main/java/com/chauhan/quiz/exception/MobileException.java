package com.chauhan.quiz.exception;

import java.text.MessageFormat;

import com.chauhan.message.CustomErrorCodes;

public class MobileException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private String code;
	private String message;
	private CustomErrorCodes errorCodes;
	
	public MobileException(String code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public MobileException(CustomErrorCodes errorCode) {
		this.code = errorCode.getCode();
		this.message = errorCode.getMessage();
		this.errorCodes = errorCode;
	}
	
	public MobileException(CustomErrorCodes e, Object... objects ) {
		this.errorCodes = e;
		this.message = MessageFormat.format(e.getMessage(), objects);
		this.errorCodes = e;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public CustomErrorCodes getErrorCodes() {
		return errorCodes;
	}

	public void setErrorCodes(CustomErrorCodes errorCodes) {
		this.errorCodes = errorCodes;
	}
}
