package kms.rooftop.data_ingest_service.listener;

import kms.rooftop.data_ingest_service.dto.event.BlobUploadSuccessEvent;
import kms.rooftop.data_ingest_service.service.ReportDataService;
import kms.rooftop.data_ingest_service.utils.JacksonUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
@Slf4j
@RequiredArgsConstructor
public class ReportEventListener {

    private final ReportDataService reportDataService;

    @Bean
    public Consumer<String> reportConsumer() {
        return s -> {
            BlobUploadSuccessEvent event = JacksonUtil.toObject(s, BlobUploadSuccessEvent.class);

            reportDataService.handleReportEventData(event);
        };
    }

}
