package com.espark.adarsh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ApiGatewayApplicationMain {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplicationMain.class, args);
	}

}
