package com.shippingmicroservice.service;

import com.shippingmicroservice.dto.PaymentDto;
import com.shippingmicroservice.dto.ReportDto;
import com.shippingmicroservice.dto.ShippingDto;
import com.shippingmicroservice.entity.Shipping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ShippingService {

    Mono<Shipping> saveShipping(ShippingDto shippingDto);

    Mono<ShippingDto> getShippingById(Long trackingNumber);

    Mono<ShippingDto> updateShipping(ShippingDto shippingDto, Long trackingNumber);

    Mono<Void> deleteShipping(Long trackingNumber);

    Flux<ShippingDto> getAllShippings();

    Mono<ReportDto> createReport(ReportDto reportDto);

    PaymentDto createPayment(PaymentDto paymentDto);

    Flux<PaymentDto> getPayments();

    Mono<PaymentDto> getPayment(Long paymentId);

    Mono<Void> deletePayment(Long paymentId);

}
