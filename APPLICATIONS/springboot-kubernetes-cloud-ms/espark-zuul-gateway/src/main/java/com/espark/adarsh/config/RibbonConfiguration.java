package com.espark.adarsh.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.ribbon.StaticServerList;
import org.springframework.context.annotation.Bean;

public class RibbonConfiguration {

    @Autowired
    private DiscoveryClient discoveryClient;

    private String serviceId = "client";

    public RibbonConfiguration() {
    }

    public RibbonConfiguration(String serviceId) {
        this.serviceId = serviceId;
    }

    @Bean
    @ConditionalOnMissingBean
    public ServerList<?> ribbonServerList(IClientConfig config) {
        Server[] servers = discoveryClient.getInstances(config.getClientName()).stream()
                .map(i -> new Server(i.getHost(), i.getPort()))
                .toArray(Server[]::new);
        return new StaticServerList(servers);
    }
}
