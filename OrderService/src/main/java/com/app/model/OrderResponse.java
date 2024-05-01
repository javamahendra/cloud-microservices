package com.app.model;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponse {
	private long orderId;
    private Instant orderDate;
    private String orderStatus;
    private double amount;
    private ProductDetails productDetails;
    private PaymentResponse paymentDetails;
}
