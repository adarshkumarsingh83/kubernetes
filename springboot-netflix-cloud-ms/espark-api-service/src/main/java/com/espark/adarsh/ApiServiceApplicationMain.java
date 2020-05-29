package com.espark.adarsh;

import com.espark.adarsh.config.ServiceNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@EnableCircuitBreaker
@SpringBootApplication
public class ApiServiceApplicationMain {

	public static void main(String[] args) {
		SpringApplication.run(ApiServiceApplicationMain.class, args);
	}

}
