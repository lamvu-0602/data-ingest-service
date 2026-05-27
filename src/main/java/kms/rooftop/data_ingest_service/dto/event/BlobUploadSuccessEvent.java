package kms.rooftop.data_ingest_service.dto.event;

public record BlobUploadSuccessEvent(String key, String blobUrl) {
}