package com.espark.adarsh.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "espark.kube.config.api")
public class ApplicationPropsConfig {

    private String name = "Adarsh Kumar";
    private String message = "Welcome to Espark Kubernates From Api Service";

}

