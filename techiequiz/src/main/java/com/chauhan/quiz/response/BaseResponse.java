package com.chauhan.quiz.response;

import java.util.ArrayList;
import java.util.List;

import com.chauhan.quiz.response.element.Error;

public class BaseResponse {
	
	List<Error> error;

	public List<Error> getError() {
		return error;
	}
	
	public List<Error> setError(List<Error> error) {
		return this.error = error;
	}

	public void addError(Error error) {
		if (this.error == null) {
			this.error  = new ArrayList<>();
		}
		this.error.add(error);
	}
}
