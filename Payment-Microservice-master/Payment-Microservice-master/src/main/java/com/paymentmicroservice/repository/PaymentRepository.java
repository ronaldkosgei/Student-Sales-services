package com.paymentmicroservice.repository;

import com.paymentmicroservice.entity.Payment;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface PaymentRepository extends R2dbcRepository<Payment, Long> {
}
