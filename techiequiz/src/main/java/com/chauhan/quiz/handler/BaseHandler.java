package com.chauhan.quiz.handler;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import com.chauhan.message.CustomErrorCodes;
import com.chauhan.quiz.exception.MobileException;
import com.chauhan.quiz.request.BaseRequest;
import com.chauhan.quiz.response.BaseResponse;
import com.chauhan.quiz.response.element.Error;

public abstract class BaseHandler<U extends RequestEntity<? extends BaseRequest> , T extends ResponseEntity<? extends BaseResponse>> {

	public T execute(U request) {
		try {
			return handle(request);
		} catch (MobileException me) {
			T t = createErrorResposne();
			t.getBody().addError(new Error(me));
			return t;
		} catch (Exception e) {
			T t = createErrorResposne();
			MobileException m = new MobileException(CustomErrorCodes.M0001);
			t.getBody().addError(new Error(m));
			return t;
		}
	}
	
	protected abstract T handle(U request) throws MobileException, Exception;
	
	protected abstract T createErrorResposne();
	//protected abstract T createErrorResposne(MobileException me);
}
