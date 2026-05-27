package kms.rooftop.data_ingest_service.service;

import kms.rooftop.data_ingest_service.dto.event.BlobUploadSuccessEvent;

public interface ReportDataService {
    void handleReportEventData(BlobUploadSuccessEvent event);
}
