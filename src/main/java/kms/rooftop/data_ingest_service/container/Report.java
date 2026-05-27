package kms.rooftop.data_ingest_service.container;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

import java.time.Instant;

@Container(containerName = "reports")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Report {

    @Id
    private String key;

    @PartitionKey
    @JsonProperty("report_type")
    private String reportType;

    private String data;

    @JsonProperty("datetime_added")
    @CreatedDate
    private Instant datetimeAdded;

    public Report(String key, String data, String reportType) {
        this.key = key;
        this.data = data;
        this.reportType = reportType;
    }

}
