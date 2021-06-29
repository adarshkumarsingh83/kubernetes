package com.espark.adarsh.config;

import com.espark.adarsh.bean.HazelCastBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
@Configuration
public class ApplicationConfig {


    @Value("${hazelcast.url}")
    private String[] hazelcastUrl;

    @Bean
    public ClientConfig clientConfig() {
        ClientConfig config = new ClientConfig();
        config.getNetworkConfig().addAddress(hazelcastUrl)
                .setSmartRouting(true)
                .addOutboundPortDefinition("34700-34710")
                .setRedoOperation(true)
                .setConnectionTimeout(5000);
        config.setInstanceName("espark-cache");
        return config;
    }


    @Bean
    public HazelcastInstance hazelcastInstance(ClientConfig clientConfig) {
        HazelcastInstance instance = HazelcastClient.newHazelcastClient(clientConfig);
        return instance;
    }

    @Bean
    public Map<String, HazelCastBean> dataStore(HazelcastInstance hazelcastInstance) {
        return hazelcastInstance.getMap("espark-cache");
    }


}

