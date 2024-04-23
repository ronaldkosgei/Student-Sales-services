package com.reportmicroservice.repository;

import com.reportmicroservice.entity.Report;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReportRepository extends R2dbcRepository<Report, Long> {
}
