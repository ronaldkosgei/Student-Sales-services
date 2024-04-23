package com.customermicroservice.controller;

import com.customermicroservice.dto.CustomerDto;
import com.customermicroservice.dto.OrderDto;
import com.customermicroservice.entity.Customer;
import com.customermicroservice.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customers")
@Slf4j
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {

        this.customerService = customerService;
    }

    @PostMapping("/save")
    public Mono<Customer> saveCustomer(@RequestBody CustomerDto customerDto) {
        return customerService.saveCustomer(customerDto);
    }

    @GetMapping("/get/{customerId}")
    public Mono<CustomerDto> getCustomerById(@PathVariable Long customerId) {
        return customerService.getCustomerById(customerId);
    }

    @GetMapping("/getemail/{email}")
    public Mono<CustomerDto> getCustomerByEmail(@RequestParam String email) {
        return customerService.getCustomerByEmail(email);
    }

    @GetMapping("/getAll")
    public Flux<CustomerDto> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PutMapping("/update/{customerId}")
    public Mono<CustomerDto> updateCustomer(@RequestBody CustomerDto customerDto,
                                            @PathVariable Long customerId) {
        return customerService.updateCustomer(customerDto, customerId);
    }

    @DeleteMapping("/delete/{customerId}")
    public Mono<Void> deleteCustomerById(@PathVariable Long customerId) {
        return customerService.deleteCustomerById(customerId);
    }

    @DeleteMapping("/delete{email}")
    public Mono<Void> deleteCustomerByEmail(@RequestParam("email") String email) {
        return customerService.deleteCustomerByEmail(email);
    }

    @GetMapping("/order/{customerId}")
    public Flux<OrderDto> getOrderByCustomerId(@PathVariable Long customerId) {
        return customerService.getOrderByCustomerId(customerId);
    }

    @GetMapping("/order")
    public Flux<OrderDto> getAllOrders() {
        return customerService.getAllOrders();
    }

    @PostMapping("/create")
    public OrderDto saveOder(@RequestBody OrderDto orderDto) {
        return customerService.saveOrder(orderDto);
    }

    @PutMapping("/update/order/{orderId}")
    public Mono<OrderDto> updateOrder(@RequestBody OrderDto orderDto,
                                      @PathVariable Long orderId) {
        return customerService.updateOrder(orderDto, orderId);
    }


    @DeleteMapping("/delete/order/{orderId}")
    public Mono<Void> deleteOrder(@PathVariable Long orderId) {
        return customerService.deleteOrder(orderId);
    }
}


