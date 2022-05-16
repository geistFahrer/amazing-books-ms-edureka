package com.bishu.issuerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class IssuerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(IssuerServiceApplication.class, args);
	}

}
