package com.espark.adarsh.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/api/**")
                        //Pre and Post Filters provided by Spring Cloud Gateway
                        .filters(f -> f.addRequestHeader("api-request", "api-request-header")
                                .addResponseHeader("api-response", "api-response-header"))
                        .uri("lb://espark-api-service")
                        .id("espark-api-service"))
                .build();
    }


}