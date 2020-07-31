package com.espark.adarsh.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@NoArgsConstructor
@ConfigurationProperties("spring.application")
public class ApplicationPropConfig {

    String email;
    String phone;
    String secretId;


}
