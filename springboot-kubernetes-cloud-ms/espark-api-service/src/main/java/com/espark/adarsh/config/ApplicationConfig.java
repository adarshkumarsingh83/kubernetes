package com.espark.adarsh.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Configuration
public class ApplicationConfig {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        log.debug("label=ApplicationConfig restTemplate()");
        RestTemplate restTemplate = builder.build();
        List<ClientHttpRequestInterceptor> interceptors
                = restTemplate.getInterceptors();
        if (CollectionUtils.isEmpty(interceptors)) {
            interceptors = new ArrayList<>();
        }
        interceptors.add(new RestTemplateInterceptor());
        restTemplate.setInterceptors(interceptors);
        return restTemplate;
    }

    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }
}
