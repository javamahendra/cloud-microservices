package com.app.exception;

import lombok.Data;

@Data
public class OrderServiceCustomException extends Exception {

	private String errorCode;

	public OrderServiceCustomException(String message, String errorCode) {
		super(message);
		this.errorCode = errorCode;
	}
}
