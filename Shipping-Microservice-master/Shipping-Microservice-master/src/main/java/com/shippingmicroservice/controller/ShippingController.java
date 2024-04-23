package com.shippingmicroservice.controller;

import com.shippingmicroservice.dto.PaymentDto;
import com.shippingmicroservice.dto.ReportDto;
import com.shippingmicroservice.dto.ShippingDto;
import com.shippingmicroservice.entity.Shipping;
import com.shippingmicroservice.service.ShippingService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/shipping")
public class ShippingController {

    private final ShippingService shippingService;

    public ShippingController(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    @PostMapping("/save")
    public Mono<Shipping> saveShipping(@RequestBody ShippingDto shippingDto) {
        return shippingService.saveShipping(shippingDto);
    }

    @GetMapping("/get/{trackingNumber}")
    public Mono<ShippingDto> getShippingById(@PathVariable Long trackingNumber) {
        return shippingService.getShippingById(trackingNumber);
    }

    @GetMapping("/all")
    public Flux<ShippingDto> getAllShippings() {
        return shippingService.getAllShippings();
    }

    @PutMapping("/update/{trackingNumber}")
    public Mono<ShippingDto> updateShipping(@RequestBody ShippingDto shippingDto,
                                            @PathVariable Long trackingNumber) {
        return shippingService.updateShipping(shippingDto, trackingNumber);
    }

    @DeleteMapping("/delete/{trackingNumber}")
    public Mono<Void> deleteShipping(@PathVariable Long trackingNumber) {
        return shippingService.deleteShipping(trackingNumber);
    }

    @PutMapping("/create")
    public Mono<ReportDto> createReport(@RequestBody ReportDto reportDto) {
        return shippingService.createReport(reportDto);
    }

    @PostMapping("/create/payment")
    public PaymentDto createPayment(@RequestBody PaymentDto paymentDto){
        return shippingService.createPayment(paymentDto);
    }

    @GetMapping("/get/payment/{paymentId}")
    public Mono<PaymentDto> getPayment(@PathVariable Long paymentId){
        return shippingService.getPayment(paymentId);
    }

    @GetMapping("/payments")
    public Flux<PaymentDto> getPayments(){
        return shippingService.getPayments();
    }

    @DeleteMapping("/delete/payment/{paymentId}")
    public Mono<Void> deletePayment(@PathVariable Long paymentId){
        return shippingService.deletePayment(paymentId);
    }
}
