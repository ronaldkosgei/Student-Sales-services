package com.shippingmicroservice.entity;

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
@Table(name = "tbl_shipping")
public class Shipping {

    @Id
    @Column("tracking_number")
    private Long trackingNumber;

    @Column("shipping_date")
    private String shippingDate;

    @Column("origin")
    private String origin;

    @Column("shipping_address")
    private String shippingAddress;

    @Column("weight")
    private String weight;

    @Column("shipping_cost")
    private Double shippingCost;

    @Column("shipping_status")
    private String shippingStatus;

    @Column("carrier_information")
    private String carrierInformation;

    @Column("report_id")
    private Long reportId;

}
