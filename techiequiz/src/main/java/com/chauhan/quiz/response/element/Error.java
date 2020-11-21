package com.chauhan.quiz.response.element;

import com.chauhan.message.CustomErrorCodes;
import com.chauhan.quiz.exception.MobileException;

public class Error {

	private String code;
	private String message;
	
	public Error() {
	}
	
	public Error(MobileException me) {
		this.code = me.getCode();
		this.message = me.getMessage();
	}
	
	public Error(String code) {
		this.code = code;
	}

	public Error(String code, String message) {
		this.code = code;
		this.message = message;
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
}
