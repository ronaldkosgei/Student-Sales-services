package com.inventorymicroservice.repository;

import com.inventorymicroservice.entity.Inventory;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface InventoryRepository extends R2dbcRepository<Inventory, Long> {

    Flux<Inventory> findByProductId(Long productId);
}

