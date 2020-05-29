package com.espark.adarsh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
public class AddressServiceApplicationMain {

	public static void main(String[] args) {
		SpringApplication.run(AddressServiceApplicationMain.class, args);
	}

}
