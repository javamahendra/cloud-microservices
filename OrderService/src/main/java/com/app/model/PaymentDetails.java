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
public class PaymentDetails {
	private long paymentId;
    private PaymentMode paymentMode;
    private String paymentStatus;
    private Instant paymentDate;
}
