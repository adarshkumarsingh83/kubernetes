package com.espark.adarsh.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("spring.data.cassandra")
public class ApplicationProps {


    Integer port;
    String keyspaceName;
    String contactPoints;
    String schemaAction;
    String localDatacenter;
    String entityBasePackage;
    String username;
    String password;
}
