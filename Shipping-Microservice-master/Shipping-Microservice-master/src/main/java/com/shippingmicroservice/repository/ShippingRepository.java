package com.shippingmicroservice.repository;

import com.shippingmicroservice.entity.Shipping;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface ShippingRepository extends R2dbcRepository<Shipping, Long> {
}
