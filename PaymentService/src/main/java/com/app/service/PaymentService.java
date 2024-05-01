package com.app.service;

import com.app.model.PaymentRequest;
import com.app.model.PaymentResponse;

public interface PaymentService {

	long doPayment(PaymentRequest paymentRequest);

	PaymentResponse getPaymentDetails(long orderId);

}
