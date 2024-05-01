package com.app.service;

import org.springframework.stereotype.Service;

import com.app.model.OrderRequest;
import com.app.model.OrderResponse;
import com.app.exception.OrderServiceCustomException;

@Service
public interface OrderService {
	

	public Long placeOrder(OrderRequest orderRequest);

	public OrderResponse getOrderDetails(long orderId) throws OrderServiceCustomException;
}
