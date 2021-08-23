package org.boilerplate.microservice.controller;

import org.boilerplate.microservice.configuration.ApplicationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationConfigRestController {

	@Autowired
	private ApplicationConfig appConfig;

	@GetMapping("/properties")
	public String getProperties() {
	
		return appConfig.toString();

	}

}
