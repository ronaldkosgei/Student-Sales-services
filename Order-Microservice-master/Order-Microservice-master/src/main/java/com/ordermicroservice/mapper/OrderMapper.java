package com.ordermicroservice.mapper;

import com.ordermicroservice.dto.OrderDto;
import com.ordermicroservice.entity.Order;

public class OrderMapper {

    public static OrderDto mapToOrderDto(Order order){
        OrderDto orderDto = new OrderDto();
        orderDto.setOrderId(order.getOrderId());
        orderDto.setItem(order.getItem());
        orderDto.setQuantity(order.getQuantity());
        orderDto.setOrderStatus(order.getOrderStatus());
        orderDto.setOrderDate(order.getOrderDate());
        orderDto.setDeliveryDate(order.getDeliveryDate());
        orderDto.setInventoryId(order.getInventoryId());
        orderDto.setCustomerId(order.getCustomerId());

        return orderDto;
    }

    public static Order mapToOrder(OrderDto orderDto){
        Order order = new Order();
        order.setOrderId(orderDto.getOrderId());
        order.setItem(orderDto.getItem());
        order.setQuantity(orderDto.getQuantity());
        order.setOrderStatus(orderDto.getOrderStatus());
        order.setOrderDate(orderDto.getOrderDate());
        order.setCustomerId(orderDto.getCustomerId());
        order.setDeliveryDate(orderDto.getDeliveryDate());
        order.setInventoryId(orderDto.getInventoryId());

        return order;
    }
}