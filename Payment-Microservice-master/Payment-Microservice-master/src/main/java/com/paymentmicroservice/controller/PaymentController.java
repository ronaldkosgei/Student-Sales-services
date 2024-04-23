package com.paymentmicroservice.controller;

import com.paymentmicroservice.dto.PaymentDto;
import com.paymentmicroservice.entity.Payment;
import com.paymentmicroservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/payment")
public class PaymentController {


    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/save")
    public Mono<Payment> savePayment(@RequestBody PaymentDto paymentDto) {
        return paymentService.savePayment(paymentDto);
    }

    @GetMapping("/payment/get/{paymentId}")
    public Mono<PaymentDto> getPayment(@PathVariable Long paymentId) {
        return paymentService.getPayment(paymentId);
    }

    @GetMapping("/payments")
    public Flux<PaymentDto> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @PutMapping("/update/{paymentId}")
    public Mono<PaymentDto> updatePayment(@RequestBody PaymentDto paymentDto,
                                          @PathVariable Long paymentId) {
        return paymentService.updatePayment(paymentDto, paymentId);
    }

    @DeleteMapping("/delete/{paymentId}")
    public Mono<Void> deletePayment(@PathVariable Long paymentId) {
        return paymentService.deletePayment(paymentId);
    }

}
