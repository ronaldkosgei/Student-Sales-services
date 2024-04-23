package com.paymentmicroservice.mapper;

import com.paymentmicroservice.dto.PaymentDto;
import com.paymentmicroservice.entity.Payment;

public class PaymentMapper {

    public static PaymentDto mapToPaymentDto(Payment payment){
        PaymentDto paymentDto = new PaymentDto();
        paymentDto.setPaymentId(payment.getPaymentId());
        paymentDto.setPaymentDate(payment.getPaymentDate());
        paymentDto.setPaymentStatus(payment.getPaymentStatus());
        paymentDto.setPaymentMethod(payment.getPaymentMethod());
        paymentDto.setAmount(payment.getAmount());
        paymentDto.setOrderId(paymentDto.getOrderId());
        paymentDto.setReportId(payment.getReportId());

        return paymentDto;
    }

    public static Payment mapToPayment(PaymentDto paymentDto){
        Payment payment = new Payment();
        payment.setPaymentId(paymentDto.getPaymentId());
        payment.setPaymentDate(paymentDto.getPaymentDate());
        payment.setPaymentStatus(paymentDto.getPaymentStatus());
        payment.setPaymentMethod(paymentDto.getPaymentMethod());
        payment.setAmount(paymentDto.getAmount());
        payment.setOrderId(paymentDto.getOrderId());
        payment.setReportId(paymentDto.getReportId());

        return payment;
    }
}
