package com.reportmicroservice.service;

import com.reportmicroservice.dto.ReportDto;
import com.reportmicroservice.entity.Report;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ReportService {

    Mono<Report> saveReport(ReportDto reportDto);

    Mono<ReportDto> getReportById(Long reportId);

    Flux<ReportDto> getAllReports();

    Mono<ReportDto> updateReport(Long reportId, ReportDto reportDto);

    Mono<Void> deleteReport(Long reportId);
}
