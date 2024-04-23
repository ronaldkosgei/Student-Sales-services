package com.reportmicroservice.entity;

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
@Table(name = "tbl_report")
public class Report {

    @Id
    @Column("report_id")
    private Long reportId;

    @Column("report_name")
    private String reportName;

    @Column("sales_per_month")
    private String salesPerMonth;

    @Column("sales_channels")
    private String salesChannels;

    @Column("sales_target")
    private String salesTarget;

    @Column("report_date")
    private String reportDate;

    @Column("sales_perfomance")
    private String salesPerfomance;

    @Column("tracking_number")
    private Long trackingNumber;

    @Column("payment_id")
    private Long paymentId;
}
