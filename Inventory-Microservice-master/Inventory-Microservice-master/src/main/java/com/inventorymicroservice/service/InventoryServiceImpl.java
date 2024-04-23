package com.inventorymicroservice.service;

import com.inventorymicroservice.dto.InventoryDto;
import com.inventorymicroservice.entity.Inventory;
import com.inventorymicroservice.mapper.InventoryMapper;
import com.inventorymicroservice.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class InventoryServiceImpl implements InventoryService{

    @Autowired
    private final InventoryRepository inventoryRepository;

    public InventoryServiceImpl(InventoryRepository inventoryRepository){
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public Mono<Inventory> saveInventory(InventoryDto inventoryDto) {
        Inventory inventory = InventoryMapper.mapToInventory(inventoryDto);
        Mono<Inventory> savedInventory = inventoryRepository.save(inventory);
        return inventoryRepository.save(inventory);
    }

    @Override
    public Mono<InventoryDto> getInventory(Long productId) {
        Mono<Inventory> inventoryMono = inventoryRepository.findById(productId);
        return inventoryMono.map(inventory -> InventoryMapper.mapToInventoryDto(inventory));
    }

    @Override
    public Flux<InventoryDto> getAllInventory() {
        Flux<Inventory> inventoryFlux = inventoryRepository.findAll();
        return inventoryFlux
                .map((inventory) -> InventoryMapper.mapToInventoryDto(inventory))
                .switchIfEmpty(Flux.empty());
    }

    @Override
    public Mono<InventoryDto> updateInventory(Long productId, InventoryDto inventoryDto) {
        Mono<Inventory> inventoryDtoMono = inventoryRepository.findById(productId);
        return inventoryDtoMono.flatMap((existingInventory) -> {
            existingInventory.setProductName(inventoryDto.getProductName());
            existingInventory.setProductPrice(inventoryDto.getProductPrice());
            existingInventory.setLocation(inventoryDto.getLocation());
            existingInventory.setLastUpdated(inventoryDto.getLastUpdated());
            return inventoryRepository.save(existingInventory);
        }).map(inventory -> InventoryMapper.mapToInventoryDto(inventory));

    }

    @Override
    public Mono<Void> deleteInventory(Long productId) {
        Mono<Inventory> inventoryMono = inventoryRepository.findById(productId);
        return inventoryMono.flatMap(inventory -> inventoryRepository.delete(inventory));
    }

    @Override
    public Flux<InventoryDto> getInventoryById(Long productId) {
        Flux<Inventory> inventoryFlux = inventoryRepository.findByProductId(productId);
        return inventoryFlux
                .map((inventory) -> InventoryMapper.mapToInventoryDto(inventory))
                .switchIfEmpty(Flux.empty());
    }


}
