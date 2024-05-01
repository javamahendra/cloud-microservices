package com.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(OrderServiceCustomException.class)
	public ResponseEntity<ErrorResponse> handleProductServiceException(OrderServiceCustomException exception){
		ErrorResponse response = ErrorResponse.builder()
				.message(exception.getMessage())
				.errorCode(exception.getErrorCode())
				.build();
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
}
