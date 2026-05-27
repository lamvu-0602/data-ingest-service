package kms.rooftop.data_ingest_service.service.serviceImpl;

import kms.rooftop.data_ingest_service.container.Report;
import kms.rooftop.data_ingest_service.dto.event.BlobUploadSuccessEvent;
import kms.rooftop.data_ingest_service.repository.ReportRepository;
import kms.rooftop.data_ingest_service.service.ReportDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReportDataServiceImpl implements ReportDataService {

    private final ReportRepository reportRepository;

    @Override
    public void handleReportEventData(BlobUploadSuccessEvent event) {
        log.info("Received event key: {}", event.key());

        Report report = new Report(event.key(), event.blobUrl(), "blob-report");
        log.info("Success save event into report for key: {}", event.key());
        reportRepository.save(report);
    }
}
