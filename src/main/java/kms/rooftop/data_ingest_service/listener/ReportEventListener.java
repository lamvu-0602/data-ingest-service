package kms.rooftop.data_ingest_service.listener;

import com.azure.spring.messaging.AzureHeaders;
import kms.rooftop.data_ingest_service.dto.event.BlobUploadSuccessEvent;
import kms.rooftop.data_ingest_service.service.ReportDataService;
import kms.rooftop.data_ingest_service.utils.JacksonUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
@Slf4j
@RequiredArgsConstructor
public class ReportEventListener {

    private final ReportDataService reportDataService;

    @Bean
    public Consumer<Message<String>> reportConsumer() {
        return this::handleReportData;
    }

    @Bean
    public Consumer<Message<String>> reportConsumer1() {
        return this::handleReportData;
    }

    private void handleReportData(Message<String> s) {
        Object partitionId = s.getHeaders().get(AzureHeaders.PARTITION_ID);
        log.info("Handle report data from consumer [Partition: {}]: {}", partitionId, s.getPayload());
        BlobUploadSuccessEvent event = JacksonUtil.toObject(s.getPayload(), BlobUploadSuccessEvent.class);

        reportDataService.handleReportEventData(event);
    }

}
