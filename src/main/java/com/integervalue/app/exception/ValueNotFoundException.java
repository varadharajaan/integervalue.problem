package com.integervalue.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Product not found")
public class ValueNotFoundException extends Exception {
	
	public ValueNotFoundException() {
		super();
	}

	public ValueNotFoundException(String message) {
		super(message);
	}

}
