package com.paymentmicroservice.service;

import com.paymentmicroservice.dto.PaymentDto;
import com.paymentmicroservice.entity.Payment;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PaymentService {


    Mono<Payment> savePayment(PaymentDto paymentDto);

    Mono<PaymentDto> updatePayment(PaymentDto paymentDto, Long paymentId);

    Flux<PaymentDto> getAllPayments();

    Mono<PaymentDto> getPayment(Long paymentId);

    Mono<Void> deletePayment(Long paymentId);
}

