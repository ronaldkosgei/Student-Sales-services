package com.customermicroservice.repository;

import com.customermicroservice.entity.Customer;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

public interface CustomerRepository extends R2dbcRepository<Customer, Long> {


    Mono<Customer> findByEmail(String email);
}
