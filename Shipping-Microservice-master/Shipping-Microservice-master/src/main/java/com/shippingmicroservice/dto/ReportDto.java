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
public class ReportDto {


    @Id
    @Column("report_id")
    private Long reportId;

    @Column("report_name")
    private String reportName;

    @Column("sales_perfomance_per_month")
    private String salesPerfomancePerMonth;

    @Column("sales_channels")
    private String salesChannels;

    @Column("sales_target")
    private String salesTarget;

    @Column("report_date")
    private String reportDate;

    @Column("sales_perfomance")
    private String salesPerfomance;

}
