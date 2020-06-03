package com.espark.adarsh.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class ApplicationConfig {


        @Bean
        public ClientConfig clientConfig() throws Exception {
            log.warn("Creating 'ClientConfig' manually not autoconfigure");
            ClientConfig clientConfig = new ClientConfig();
            clientConfig.getNetworkConfig().addAddress("127.0.0.1","192.168.64.1:5701","localhost:5701");
            return clientConfig;
        }

    @Configuration
    @ConditionalOnMissingBean(HazelcastInstance.class)
    static class HazelcastClientConfiguration {

        @Bean
        public HazelcastInstance hazelcastInstance(ClientConfig clientConfig) {
            log.warn("Creating client 'HazelcastInstance' manually not autoconfigure");
            return HazelcastClient.newHazelcastClient(clientConfig);
        }
    }


}

