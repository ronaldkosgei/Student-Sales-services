package com.inventorymicroservice.entity;

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
@Table(name = "tbl_inventory")
public class Inventory {

    @Id
    @Column("product_id")
    private Long productId;

    @Column("product_name")
    private String productName;

    @Column("product_price")
    private String productPrice;

    @Column("location")
    private String location;

    @Column("last_updated")
    private String lastUpdated;

    @Column("order_id")
    private Long orderId;

}

