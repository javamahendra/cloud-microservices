package com.app.client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.app.model.PaymentResponse;

@FeignClient(name="PAYMENTSERVICE/payment")
public interface PaymentService {
	
	@GetMapping("/{orderId}")
	public ResponseEntity<PaymentResponse> getPaymentDetails(@PathVariable long orderId);
}

