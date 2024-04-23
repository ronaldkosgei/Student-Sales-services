package com.ordermicroservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_order")
public class Order {

    @Id
    @Column("order_id")
    private Long orderId;

    @Column("items")
    private  String item;

    @Column("quantity")
    private String quantity;

    @Column("order_status")
    private String orderStatus;

    @Column("order_date")
    private String orderDate;

    @Column("delivery_date")
    private String deliveryDate;

    @Column("inventory_id")
    private Long inventoryId;

    @Column("customer_id")
    private Long customerId;

}
