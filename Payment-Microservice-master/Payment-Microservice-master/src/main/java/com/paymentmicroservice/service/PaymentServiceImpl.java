package com.paymentmicroservice.service;

import com.paymentmicroservice.dto.PaymentDto;
import com.paymentmicroservice.entity.Payment;
import com.paymentmicroservice.mapper.PaymentMapper;
import com.paymentmicroservice.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PaymentServiceImpl implements PaymentService {


    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Mono<Payment> savePayment(PaymentDto paymentDto) {
        Payment payment = PaymentMapper.mapToPayment(paymentDto);
        Mono<Payment> savedPayment = paymentRepository.save(payment);
        return paymentRepository.save(payment);
    }


    @Override
    public Mono<PaymentDto> updatePayment(PaymentDto paymentDto, Long paymentId) {
        Mono<Payment> paymentMono = paymentRepository.findById(paymentId);
        return paymentMono.flatMap((existingPayment) -> {

            existingPayment.setAmount(paymentDto.getAmount());
            existingPayment.setPaymentDate(paymentDto.getPaymentDate());
            existingPayment.setPaymentMethod(paymentDto.getPaymentMethod());
            existingPayment.setPaymentStatus(paymentDto.getPaymentStatus());
            existingPayment.setOrderId(paymentDto.getOrderId());
            return paymentRepository.save(existingPayment);
        }).map(payment -> PaymentMapper.mapToPaymentDto(payment));

    }

    @Override
    public Flux<PaymentDto> getAllPayments() {
        Flux<Payment> paymentFlux = paymentRepository.findAll();
        return paymentFlux
                .map((payment) -> PaymentMapper.mapToPaymentDto(payment))
                .switchIfEmpty(Flux.empty());
    }

    @Override
    public Mono<PaymentDto> getPayment(Long paymentId) {
        Mono<Payment> paymentMono = paymentRepository.findById(paymentId);
        return paymentMono.map(payment -> PaymentMapper.mapToPaymentDto(payment));
    }

    @Override
    public Mono<Void> deletePayment(Long paymentId) {
        Mono<Payment> paymentMono = paymentRepository.findById(paymentId);
        return paymentMono.flatMap(payment -> paymentRepository.delete(payment));
    }
}