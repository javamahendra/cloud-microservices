package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.PaymentRequest;
import com.app.model.PaymentResponse;
import com.app.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@PostMapping("/doPayment")
	public ResponseEntity<Long> doPayment(@RequestBody PaymentRequest paymentRequest){
		long paymentId = paymentService.doPayment(paymentRequest);
		return new ResponseEntity<Long>(paymentId, HttpStatus.OK);
	}
	
	@GetMapping("/{orderId}")
	public ResponseEntity<PaymentResponse> getPaymentDetails(@PathVariable long orderId){
		PaymentResponse paymentResponse = paymentService.getPaymentDetails(orderId);
		return new ResponseEntity<PaymentResponse>(paymentResponse, HttpStatus.OK);
	}

}
