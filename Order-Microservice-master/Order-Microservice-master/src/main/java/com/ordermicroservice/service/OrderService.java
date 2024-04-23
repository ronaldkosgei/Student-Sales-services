package com.ordermicroservice.service;

import com.ordermicroservice.dto.CustomerDto;
import com.ordermicroservice.dto.InventoryDto;
import com.ordermicroservice.dto.OrderDto;
import com.ordermicroservice.entity.Order;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OrderService {


    Mono<Order> saveOrder(OrderDto orderDto);

    Mono<OrderDto> getOrder(Long orderId);

    Flux<OrderDto> getAllOrders();

    Mono<OrderDto> updateOrder(OrderDto orderDto, Long orderId);

    Mono<Void> deleteOrderById(Long orderId);


    Flux<Order> getOrderByCustomerId(Long customerId);

    Flux<InventoryDto> getInventoryById(Long orderId);


}
