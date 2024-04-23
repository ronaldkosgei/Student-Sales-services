package com.reportmicroservice.service;

import com.reportmicroservice.dto.ReportDto;
import com.reportmicroservice.entity.Report;
import com.reportmicroservice.mapper.ReportMapper;
import com.reportmicroservice.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private final ReportRepository reportRepository;

    public ReportServiceImpl(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public Mono<Report> saveReport(ReportDto reportDto) {
        Report report = ReportMapper.mapToReport(reportDto);
        Mono<Report> savedReporting = reportRepository.save(report);
        return reportRepository.save(report);
    }

    @Override
    public Mono<ReportDto> getReportById(Long reportId) {
        Mono<Report> reportMono = reportRepository.findById(reportId);
        return reportMono.map(report -> ReportMapper.mapToReportDto(report));
    }

    @Override
    public Flux<ReportDto> getAllReports() {
        Flux<Report> reportFlux = reportRepository.findAll();
        return reportFlux.map(report -> ReportMapper.mapToReportDto(report));
    }

    @Override
    public Mono<ReportDto> updateReport(Long reportId ,
                                        ReportDto reportDto) {
        Mono<Report> reportMono = reportRepository.findById(reportId);
        return reportMono.flatMap(report -> {
            report.setReportName(reportDto.getReportName());
            report.setSalesPerfomance(reportDto.getSalesPerfomance());
            report.setSalesChannels(reportDto.getSalesChannels());
            report.setSalesTarget(reportDto.getSalesTarget());
            report.setReportDate(reportDto.getReportDate());
            return reportRepository.save(report);
        }).map(report -> ReportMapper.mapToReportDto(report));
    }

    @Override
    public Mono<Void> deleteReport(Long reportId) {
        Mono<ReportDto> reportMono = getReportById(reportId);
        return reportMono.flatMap(reportDto -> {
            Report report = ReportMapper.mapToReport(reportDto);
            return reportRepository.delete(report);
        });
    }
}

