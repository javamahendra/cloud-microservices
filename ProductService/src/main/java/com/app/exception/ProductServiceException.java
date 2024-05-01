package com.app.exception;

import lombok.Data;

@Data
public class ProductServiceException extends Exception{
	
	private String errorCode;
	public ProductServiceException(String message, String errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

}
