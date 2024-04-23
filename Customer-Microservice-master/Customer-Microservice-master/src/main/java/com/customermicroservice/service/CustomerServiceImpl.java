package com.customermicroservice.service;


import com.customermicroservice.dto.CustomerDto;
import com.customermicroservice.dto.OrderDto;
import com.customermicroservice.entity.Customer;
import com.customermicroservice.mapper.CustomerMapper;
import com.customermicroservice.repository.CustomerRepository;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerServiceImpl implements CustomerService{


    private final CustomerRepository customerRepository;


    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }



        @Override
        public Mono<Customer> saveCustomer(CustomerDto customerDto) {
            Customer customer = CustomerMapper.mapToCustomer(customerDto);
            return customerRepository.save(customer);
        }

        @Override
        public Mono<CustomerDto> getCustomerById(Long customerId) {
            Mono<Customer> customerMono = customerRepository.findById(customerId);
            return customerMono.map(customer -> CustomerMapper.mapToCustomerDto(customer));
        }

        @Override
        public Flux<CustomerDto> getAllCustomers() {
            Flux<Customer> customerFlux = customerRepository.findAll();
            return customerFlux.map(customer -> CustomerMapper.mapToCustomerDto(customer));
        }

    @Override
    public Flux<OrderDto> getAllOrders() {
        return WebClient.create()
                .get()
                .uri("http://localhost:8081/orders/getAll")
                .retrieve()
                .bodyToFlux(OrderDto.class);
    }

    @Override
    public OrderDto saveOrder(OrderDto orderDto) {
        return WebClient.create()
                .post()
                .uri("http://localhost:8081/orders/save")
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(orderDto), OrderDto.class)
                .retrieve()
                .bodyToMono(OrderDto.class)
                .block();
    }

    @Override
    public Mono<OrderDto> updateOrder(OrderDto orderDto, Long orderId) {
        return WebClient.create()
                .put()
                .uri("http://localhost:8081/orders/update/" + orderId)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(orderDto), OrderDto.class)
                .retrieve()
                .bodyToMono(OrderDto.class);
    }

    @Override
    public Flux<OrderDto> getOrderByCustomerId(Long customerId) {
        return WebClient.create()
                .get()
                .uri("http://localhost:8081/orders/get/order/" + customerId)
                .retrieve()
                .bodyToFlux(OrderDto.class);
    }

    @Override
    public Mono<Void> deleteOrder(Long orderId) {
        return WebClient.create()
                .delete()
                .uri("http://localhost:8081/orders/delete/" + orderId)
                .retrieve()
                .bodyToMono(Void.class);
    }

    @Override
        public Mono<CustomerDto> getCustomerByEmail(String email) {
            Mono<Customer> customerMono = customerRepository.findByEmail(email);
            return customerMono.map(customer -> CustomerMapper.mapToCustomerDto(customer));
        }

        @Override
        public Mono<CustomerDto> updateCustomer(CustomerDto customerDto, Long customerId) {
            Mono<Customer> customerMono = customerRepository.findById(customerId);
            return customerMono.flatMap((existingCustomer) -> {
                existingCustomer.setFirstName(customerDto.getFirstName());
                existingCustomer.setLastName(customerDto.getLastName());
                existingCustomer.setEmail(customerDto.getEmail());
                existingCustomer.setPhoneNumber(customerDto.getPhoneNumber());
                existingCustomer.setAddress(customerDto.getAddress());
                existingCustomer.setCity(customerDto.getCity());
                existingCustomer.setOrderId(customerDto.getOrderId());
                return customerRepository.save(existingCustomer);
            }).map(customer -> CustomerMapper.mapToCustomerDto(customer));
        }

        @Override
        public Mono<Void> deleteCustomerById(Long customerId) {
            Mono<Customer> customerMono = customerRepository.findById(customerId);
            return customerMono.flatMap(customer -> customerRepository.delete(customer));
        }

        @Override
        public Mono<Void> deleteCustomerByEmail(String email) {
            Mono<Customer> customerMono = customerRepository.findByEmail(email);
            return customerMono.flatMap(customer -> customerRepository.delete(customer));
        }

}
