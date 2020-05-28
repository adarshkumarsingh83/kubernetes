package com.espark.adarsh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplicationMain {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplicationMain.class, args);
	}

}
