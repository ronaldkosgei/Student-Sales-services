package com.ordermicroservice.service;

import com.ordermicroservice.dto.CustomerDto;
import com.ordermicroservice.dto.InventoryDto;
import com.ordermicroservice.dto.OrderDto;
import com.ordermicroservice.entity.Order;
import com.ordermicroservice.mapper.OrderMapper;
import com.ordermicroservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }



    @Override
    public Mono<Order> saveOrder(OrderDto orderDto) {
        Order order = OrderMapper.mapToOrder(orderDto);
        Mono<Order> savedOrder = orderRepository.save(order);
        return savedOrder.map(orderEntity -> OrderMapper.mapToOrder(orderDto));
    }


    @Override
    public Mono<OrderDto> getOrder(Long orderId) {
        Mono<Order> orderMono = orderRepository.findById(orderId);
        return orderMono.map(order -> OrderMapper.mapToOrderDto(order));
    }

    @Override
    public Flux<OrderDto> getAllOrders() {
        Flux<Order> orderFlux = orderRepository.findAll();
        return orderFlux
                .map((order) -> OrderMapper.mapToOrderDto(order))
                .switchIfEmpty(Flux.empty());
    }

    @Override
    public Mono<OrderDto> updateOrder(OrderDto orderDto, Long orderId) {
        Mono<Order> orderMono = orderRepository.findById(orderId);
        return orderMono.flatMap((existingOrder) -> {
            existingOrder.setItem(orderDto.getItem());
            existingOrder.setQuantity(orderDto.getQuantity());
            existingOrder.setOrderStatus(orderDto.getOrderStatus());
            existingOrder.setOrderDate(orderDto.getOrderDate());
            existingOrder.setDeliveryDate(orderDto.getDeliveryDate());
            existingOrder.setInventoryId(orderDto.getInventoryId());
            existingOrder.setCustomerId(orderDto.getCustomerId());
            return orderRepository.save(existingOrder);
        }).map(order -> OrderMapper.mapToOrderDto(order));
    }

    @Override
    public Mono<Void> deleteOrderById(Long orderId) {
        Mono<Order> orderMono = orderRepository.findById(orderId);
        return orderMono.flatMap((order) -> orderRepository.delete(order));
    }

    @Override
    public Flux<Order> getOrderByCustomerId(Long customerId) {
        return orderRepository.findByCustomerId(customerId);
    }

    @Override
    public Flux<InventoryDto> getInventoryById(Long orderId) {
        return WebClient.create()
                .get()
                .uri("http://localhost:8082/inventoriess/inventory/get/" + orderId)
                .retrieve()
                .bodyToFlux(InventoryDto.class);
    }


}
