package com.espark.adarsh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CassandraApplication {



	public static void main(String[] args) throws Exception{
		java.lang.Thread.currentThread().sleep(1000L);
		SpringApplication.run(CassandraApplication.class, args);
	}

}
