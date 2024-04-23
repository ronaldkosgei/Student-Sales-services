package com.customermicroservice.service;

import com.customermicroservice.dto.CustomerDto;
import com.customermicroservice.dto.OrderDto;
import com.customermicroservice.entity.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {

    Mono<Customer> saveCustomer(CustomerDto customerDto);

    Mono<CustomerDto> getCustomerById(Long customerId);

    Mono<CustomerDto> getCustomerByEmail(String email);

    Mono<CustomerDto> updateCustomer(CustomerDto customerDto, Long customerId);

    Mono<Void> deleteCustomerById(Long customerId);

    Mono<Void> deleteCustomerByEmail(String email);

    Flux<CustomerDto> getAllCustomers();

    Flux<OrderDto> getAllOrders();

    OrderDto saveOrder(OrderDto orderDto);

    Mono<OrderDto> updateOrder(OrderDto orderDto, Long orderId);

    Flux<OrderDto> getOrderByCustomerId(Long customerId);

    Mono<Void> deleteOrder(Long orderId);
}
