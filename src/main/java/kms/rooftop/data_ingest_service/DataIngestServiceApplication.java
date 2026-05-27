package kms.rooftop.data_ingest_service;

import com.azure.spring.data.cosmos.core.mapping.EnableCosmosAuditing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableCosmosAuditing
public class DataIngestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataIngestServiceApplication.class, args);
	}

}
