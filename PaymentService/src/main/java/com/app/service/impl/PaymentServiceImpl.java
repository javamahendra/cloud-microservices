package com.app.service.impl;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.PaymentDetails;
import com.app.model.PaymentMode;
import com.app.model.PaymentRequest;
import com.app.model.PaymentResponse;
import com.app.repository.PaymentRepository;
import com.app.service.PaymentService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	@Override
	public long doPayment(PaymentRequest paymentRequest) {
		log.info("paymentRequest in PaymentServiceImpl ::" + paymentRequest);
		PaymentDetails paymentDetails = PaymentDetails.builder().amount(paymentRequest.getAmount())
				.paymentDate(Instant.now()).paymentMode(paymentRequest.getPaymentMode().name()).paymentStatus("SUCCESS")
				.orderId(paymentRequest.getOrderId()).build();
		log.info("paymentDetails in doPayment " + paymentDetails);
		paymentRepository.save(paymentDetails);
		return paymentDetails.getPaymentId();
	}

	@Override
	public PaymentResponse getPaymentDetails(long orderId) {
		PaymentDetails paymentDetails = paymentRepository.findByOrderId(orderId);

		PaymentResponse paymentResponse = new PaymentResponse();
		paymentResponse.setAmount(paymentDetails.getAmount());
		paymentResponse.setOrderId(paymentDetails.getOrderId());
		paymentResponse.setPaymentDate(paymentDetails.getPaymentDate());
		paymentResponse.setPaymentId(paymentDetails.getPaymentId());
		paymentResponse.setStatus(paymentDetails.getPaymentStatus());
		paymentResponse.setPaymentMode(PaymentMode.valueOf(paymentDetails.getPaymentMode()));
		
		return paymentResponse;
	}

}
