package com.reportmicroservice.mapper;

import com.reportmicroservice.dto.ReportDto;
import com.reportmicroservice.entity.Report;

public class ReportMapper {

    public static ReportDto mapToReportDto(Report report) {
        ReportDto reportDto = new ReportDto();
        reportDto.setReportId(report.getReportId());
        reportDto.setReportName(report.getReportName());
        reportDto.setSalesPerMonth(report.getSalesPerMonth());
        reportDto.setSalesChannels(report.getSalesChannels());
        reportDto.setSalesTarget(report.getSalesTarget());
        reportDto.setReportDate(report.getReportDate());
        reportDto.setSalesPerfomance(report.getSalesPerfomance());
        reportDto.setTrackingNumber(report.getTrackingNumber());
        reportDto.setPaymentId(report.getPaymentId());

        return reportDto;
    }

    public static Report mapToReport(ReportDto reportDto) {
        Report report = new Report();
        report.setReportId(reportDto.getReportId());
        report.setReportName(reportDto.getReportName());
        report.setSalesPerMonth(reportDto.getSalesPerMonth());
        report.setSalesChannels(reportDto.getSalesChannels());
        report.setSalesTarget(reportDto.getSalesTarget());
        report.setReportDate(reportDto.getReportDate());
        report.setSalesPerfomance(reportDto.getSalesPerfomance());
        report.setTrackingNumber(reportDto.getTrackingNumber());
        report.setPaymentId(reportDto.getPaymentId());

        return report;
    }
}
