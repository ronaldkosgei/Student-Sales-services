package com.inventorymicroservice.service;

import com.inventorymicroservice.dto.InventoryDto;
import com.inventorymicroservice.entity.Inventory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface InventoryService {


    Mono<Inventory> saveInventory(InventoryDto inventoryDto);

    Mono<InventoryDto> getInventory(Long productId);

    Flux<InventoryDto> getAllInventory();

    Mono<InventoryDto> updateInventory(Long productId, InventoryDto inventoryDto);

    Mono<Void> deleteInventory(Long productId);

    Flux<InventoryDto> getInventoryById(Long productId);


}
