package com.reportmicroservice.controller;

import com.reportmicroservice.dto.ReportDto;
import com.reportmicroservice.entity.Report;
import com.reportmicroservice.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @PostMapping("/save")
    public Mono<Report> saveReport(@RequestBody ReportDto reportDto) {
        return reportService.saveReport(reportDto);
    }

    @GetMapping("/get/{reportId}")
    public Mono<ReportDto> getReportById(@PathVariable Long reportId) {
        return reportService.getReportById(reportId);
    }

    @GetMapping("/get/all")
    public Flux<ReportDto> getAllReports() {
        return reportService.getAllReports();
    }

    @PutMapping("/update/{reportId}")
    public Mono<ReportDto> updateReport(@PathVariable Long reportId,
                                        @RequestBody ReportDto reportDto) {
        return reportService.updateReport(reportId, reportDto);
    }

    @DeleteMapping("/delete/{reportId}")
    public Mono<Void> deleteReport(@PathVariable Long reportId) {
        return reportService.deleteReport(reportId);
    }
}
