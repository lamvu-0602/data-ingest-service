package kms.rooftop.data_ingest_service.service.serviceImpl;

import com.azure.core.util.BinaryData;
import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import kms.rooftop.data_ingest_service.service.BlobStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlobStorageServiceImpl implements BlobStorageService {

    @Value("${spring.cloud.azure.storage.blob.container-name}")
    private String containerName;

    private final BlobServiceClient blobServiceClient;

    @Override
    public String getData(String key) {
        BlobContainerClient containerClient =
                blobServiceClient.getBlobContainerClient(containerName);

        String blobName = buildBlobName(key);

        BlobClient blobClient =
                containerClient.getBlobClient(blobName);

        if (!blobClient.exists()) {
            throw new RuntimeException(
                    "Blob not found: " + blobName
            );
        }

        return blobClient
                .downloadContent()
                .toString();
    }

    private String buildBlobName(String key) {
        return key + ".json";
    }
}
