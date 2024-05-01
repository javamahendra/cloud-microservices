package com.app.exception.decoder;

import java.io.IOException;

import com.app.exception.ErrorResponse;
import com.app.exception.OrderServiceCustomException;
import com.fasterxml.jackson.databind.ObjectMapper;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomDecoder implements ErrorDecoder{

	@Override
	public Exception decode(String methodKey, Response response) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			ErrorResponse errorResponse = objectMapper.readValue(response.body().asInputStream(), ErrorResponse.class);
			return new OrderServiceCustomException(errorResponse.getMessage(), errorResponse.getErrorCode());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new OrderServiceCustomException("ServiceInternalException","SERVICE_EXCEPTION");
	}

}
