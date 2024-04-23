package com.inventorymicroservice.controller;

import com.inventorymicroservice.dto.InventoryDto;
import com.inventorymicroservice.entity.Inventory;
import com.inventorymicroservice.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/inventories")
public class InventoryController {

    @Autowired
    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService){
        this.inventoryService = inventoryService;
    }

    @PostMapping("/save")
    public Mono<Inventory> saveInventory(@RequestBody InventoryDto inventoryDto){
        return inventoryService.saveInventory(inventoryDto);
    }
    @GetMapping("/inventory/{productId}")
    public  Mono<InventoryDto> getInventory(@PathVariable Long productId){
        return inventoryService.getInventory(productId);
    }

    @GetMapping("/inventory/get/{productId}")
    public  Flux<InventoryDto> getInventoryById(@PathVariable Long productId){
        return inventoryService.getInventoryById(productId);
    }

    @GetMapping("/all")
    public Flux<InventoryDto> getAllInventory(){
        return inventoryService.getAllInventory();
    }


    @PutMapping("/update/{productId}")
    public Mono<InventoryDto> updateInventory(@PathVariable Long productId,
                                              @RequestBody InventoryDto inventoryDto){
        return inventoryService.updateInventory(productId, inventoryDto);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteInventory(@PathVariable("id") Long productId){
        return inventoryService.deleteInventory(productId);
    }
}