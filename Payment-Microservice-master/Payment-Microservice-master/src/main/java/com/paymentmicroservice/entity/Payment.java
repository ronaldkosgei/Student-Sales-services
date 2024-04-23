package com.paymentmicroservice.entity;

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
@Table(name = "tbl_payment")
public class Payment {

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
