package com.shippingmicroservice.service;

import com.shippingmicroservice.dto.PaymentDto;
import com.shippingmicroservice.dto.ReportDto;
import com.shippingmicroservice.dto.ShippingDto;
import com.shippingmicroservice.entity.Shipping;
import com.shippingmicroservice.mapper.ShippingMapper;
import com.shippingmicroservice.repository.ShippingRepository;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ShippingServiceImpl implements ShippingService{

    private final ShippingRepository shippingRepository;

    public ShippingServiceImpl(ShippingRepository shippingRepository) {
        this.shippingRepository = shippingRepository;
    }

    @Override
    public Mono<Shipping> saveShipping(ShippingDto shippingDto) {
        Shipping shipping = ShippingMapper.mapToShipping(shippingDto);
        return shippingRepository.save(shipping);
    }

    @Override
    public Mono<ShippingDto> getShippingById(Long trackingNumber) {
        Mono<Shipping> shippingMono = shippingRepository.findById(trackingNumber);
        return shippingMono.map(shipping -> ShippingMapper.mapToShippingDto(shipping));
    }

    @Override
    public Mono<ShippingDto> updateShipping(ShippingDto shippingDto, Long trackingNumber) {
        Mono<Shipping> shippingMono = shippingRepository.findById(trackingNumber);
        return shippingMono.flatMap((existingShipping) -> {
            existingShipping.setOrigin(shippingDto.getOrigin());
            existingShipping.setWeight(shippingDto.getWeight());
            existingShipping.setShippingCost(shippingDto.getShippingCost());
            existingShipping.setShippingStatus(shippingDto.getShippingStatus());
            existingShipping.setCarrierInformation(shippingDto.getCarrierInformation());
            existingShipping.setShippingAddress(shippingDto.getShippingAddress());
            existingShipping.setReportId(shippingDto.getReportId());
            return shippingRepository.save(existingShipping);
        }).map(shipping -> ShippingMapper.mapToShippingDto(shipping));
    }

    @Override
    public Mono<Void> deleteShipping(Long trackingNumber) {
        Mono<Shipping> shippingMono = shippingRepository.findById(trackingNumber);
        return shippingMono.flatMap(Shipping -> shippingRepository.delete(Shipping));
    }

    @Override
    public Flux<ShippingDto> getAllShippings() {
        Flux<Shipping> shippingFlux = shippingRepository.findAll();
        return shippingFlux.map(shipping -> ShippingMapper.mapToShippingDto(shipping));
    }

    @Override
    public Mono<ReportDto> createReport(ReportDto reportDto) {
      return WebClient.create()
                .post()
                .uri("http://localhost:8084/report/save")
                .body(Mono.just(reportDto), ReportDto.class)
                .retrieve()
                .bodyToMono(ReportDto.class);
    }

    @Override
    public PaymentDto createPayment(PaymentDto paymentDto) {
        return WebClient.create()
                .post()
                .uri("http://localhost:8085/payment/save")
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(paymentDto), PaymentDto.class)
                .retrieve()
                .bodyToMono(PaymentDto.class)
                .block();
    }
    @Override
    public Flux<PaymentDto> getPayments(){
        return WebClient.create()
                .get()
                .uri("http://localhost:8085/payment/payments")
                .retrieve()
                .bodyToFlux(PaymentDto.class);
    }

    @Override
    public Mono<PaymentDto> getPayment(Long paymentId) {
        return WebClient.create()
                .get()
                .uri("http://localhost:8085/payment/payment/get/" + paymentId)
                .retrieve()
                .bodyToMono(PaymentDto.class);
    }

    @Override
    public Mono<Void> deletePayment(Long paymentId) {
        return WebClient.create()
                .delete()
                .uri("http://localhost:8085/payment/delete/" + paymentId)
                .retrieve()
                .bodyToMono(Void.class);
    }
}