package com.espark.adarsh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.hazelcast.repository.config.EnableHazelcastRepositories;

@SpringBootApplication
@EnableHazelcastRepositories
public class HazelcastKubernatesApplication {

	public static void main(String[] args) {
		SpringApplication.run(HazelcastKubernatesApplication.class, args);
	}

}
