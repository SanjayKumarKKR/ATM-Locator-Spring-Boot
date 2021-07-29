package com.atmlocator.atmlocator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class AtmLocatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtmLocatorApplication.class, args);
	}


	@Bean
	public RestTemplate getRestTemplate() throws Exception {
		RestTemplate restTemplate =new RestTemplate();
		return restTemplate;
	}

}
