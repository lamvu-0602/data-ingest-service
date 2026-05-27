package kms.rooftop.data_ingest_service.repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import kms.rooftop.data_ingest_service.container.Report;

public interface ReportRepository extends CosmosRepository<Report, String> {
}
