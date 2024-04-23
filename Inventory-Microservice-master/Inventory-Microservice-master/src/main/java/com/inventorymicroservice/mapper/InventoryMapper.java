package com.inventorymicroservice.mapper;

import com.inventorymicroservice.dto.InventoryDto;
import com.inventorymicroservice.entity.Inventory;

public class InventoryMapper {

    public static InventoryDto mapToInventoryDto(Inventory inventory) {
        InventoryDto inventoryDto = new InventoryDto();
        inventoryDto.setProductId(inventory.getProductId());
        inventoryDto.setProductName(inventory.getProductName());
        inventoryDto.setProductPrice(inventory.getProductPrice());
        inventoryDto.setLocation(inventory.getLocation());
        inventoryDto.setLastUpdated(inventory.getLastUpdated());
        inventoryDto.setOrderId(inventory.getOrderId());

        return inventoryDto;

    }

    public static Inventory mapToInventory(InventoryDto inventoryDto){
        Inventory inventory = new Inventory();
        inventory.setProductId(inventoryDto.getProductId());
        inventory.setProductName(inventoryDto.getProductName());
        inventory.setProductPrice(inventoryDto.getProductPrice());
        inventory.setLocation(inventoryDto.getLocation());
        inventory.setLastUpdated(inventoryDto.getLastUpdated());
        inventory.setOrderId(inventoryDto.getOrderId());

        return inventory;
    }
}