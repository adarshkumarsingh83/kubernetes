package com.espark.adarsh.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "espark.rabbitmq")
public class RabbitMQProperties {

    String exchange="";
    String queue="";
    String routingKey="";

}
