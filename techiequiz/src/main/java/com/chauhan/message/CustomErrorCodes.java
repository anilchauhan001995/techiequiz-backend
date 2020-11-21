package com.chauhan.message;

public enum CustomErrorCodes {

	M0001("M0001", "There is a Commom Exception from Server"),
	M0002("M0002", "Session is Invalid"),
	M0003("M0003", "No Data Found"),
	M0004("M0004", "Not Have Access for Resources");
	
	private int httpErrorType;
	private String message;
	private String code;
	
	private CustomErrorCodes(int httpErrorType, String message, String code) {
		this.httpErrorType = httpErrorType;
		this.message = message;
		this.code = code;
	}

	private CustomErrorCodes(String code, String message) {
		this.message = message;
		this.code = code;
	}

	public int getHttpErrorType() {
		return httpErrorType;
	}

	public String getMessage() {
		return message;
	}

	public String getCode() {
		return code;
	}
	
	
	
}
