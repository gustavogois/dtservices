package pt.gois.dtservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import pt.gois.dtservices.config.property.DtServicesApiProperty;

@SpringBootApplication
@EnableConfigurationProperties(DtServicesApiProperty.class)
public class DtServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DtServicesApplication.class, args);
	}
}
