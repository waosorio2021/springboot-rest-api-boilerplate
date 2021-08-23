package org.boilerplate.microservice.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;
import lombok.ToString;

@Configuration
@Data
@ToString
@ConfigurationProperties(prefix = "app")
public class ApplicationConfig {

	//@Value("${name}")
	private String name;
	
	//@Value("${year}")
	private String year;
	
	//@Value("${edition}")
	private String edition;
	
	//@Value("${countries}")
	private String countries;

}
