package com.shippingmicroservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {


    @Id
    @Column("payment_id")
    private Long paymentId;

    @Column("amount")
    private String amount;

    @Column("payment_date")
    private String paymentDate;

    @Column("payment_method")
    private String paymentMethod;

    @Column("payment_status")
    private String paymentStatus;

    @Column("order_id")
    private Long orderId;

    @Column("report_id")
    private Long reportId;
}
