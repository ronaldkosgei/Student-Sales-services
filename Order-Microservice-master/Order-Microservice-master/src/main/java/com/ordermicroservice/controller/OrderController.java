package com.ordermicroservice.controller;


import com.ordermicroservice.dto.InventoryDto;
import com.ordermicroservice.dto.OrderDto;
import com.ordermicroservice.entity.Order;
import com.ordermicroservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/orders")
public class OrderController {


    private final OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @PostMapping("/save")
    public Mono<Order> saveOrder(@RequestBody OrderDto orderDto){
        return orderService.saveOrder(orderDto);

    }
    @GetMapping("/get/{orderId}")
    public Mono<OrderDto> getOrder(@PathVariable Long orderId){
        return orderService.getOrder(orderId);
    }

    @GetMapping("/getAll")
    public Flux<OrderDto> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("/get/order/{customerId}")
    public Flux<Order> getOrderByCustomerId(@PathVariable Long customerId){
        return orderService.getOrderByCustomerId(customerId);
    }

    @PutMapping("/update/{orderId}")
    public Mono<OrderDto> updateOrder(@RequestBody OrderDto orderDto, @PathVariable Long orderId){
        return orderService.updateOrder(orderDto, orderId);
    }

    @DeleteMapping("/delete/{orderId}")
    public Mono<Void> deleteOrderById(@PathVariable Long orderId){
        return orderService.deleteOrderById(orderId);
    }

    @GetMapping("/get/inventory/{orderId}")
    public Flux<InventoryDto> getInventoryById(@PathVariable Long orderId){
        return orderService.getInventoryById(orderId);
    }



}
