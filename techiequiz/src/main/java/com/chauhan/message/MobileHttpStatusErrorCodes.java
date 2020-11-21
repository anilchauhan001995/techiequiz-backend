package com.chauhan.message;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;

public class MobileHttpStatusErrorCodes {
	
	private static Set<CustomErrorCodes> internalServerErrorStatus;
	private static Set<CustomErrorCodes> badRequestErrorStatus;
	private static Set<CustomErrorCodes> unAuthorizedErrorStatus;
	
	private static Map<HttpStatus, Set<CustomErrorCodes>> httpStausError;
	
	static {
		loadInternalServerErrorCodes();
		loadBadRequestErrorCodes();
		loadUnAuthorizedErrorCodes();
	}
	
	public static void loadInternalServerErrorCodes() {
		httpStausError = new HashMap<>();
		internalServerErrorStatus = new HashSet<>();
		internalServerErrorStatus.add(CustomErrorCodes.M0001);
		httpStausError.put(HttpStatus.INTERNAL_SERVER_ERROR, internalServerErrorStatus);
	}
	
	public static void loadBadRequestErrorCodes() {
		badRequestErrorStatus = new HashSet<>();
		badRequestErrorStatus.add(CustomErrorCodes.M0002);
		httpStausError.put(HttpStatus.BAD_REQUEST, badRequestErrorStatus);
	}
	
	public static void loadUnAuthorizedErrorCodes() {
		unAuthorizedErrorStatus = new HashSet<>();
		unAuthorizedErrorStatus.add(CustomErrorCodes.M0003);
		httpStausError.put(HttpStatus.UNAUTHORIZED, unAuthorizedErrorStatus);
	}
	
	public static HttpStatus getRespectiveHttpStatus(CustomErrorCodes code) {
		for(Map.Entry<HttpStatus, Set<CustomErrorCodes>> entry : httpStausError.entrySet()) {
			if (entry.getValue().contains(code) ) {
				return entry.getKey();
			}
		}
		return HttpStatus.INTERNAL_SERVER_ERROR;
	}

}
