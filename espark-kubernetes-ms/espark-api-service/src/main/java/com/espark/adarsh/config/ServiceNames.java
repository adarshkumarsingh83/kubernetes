package com.espark.adarsh.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "espark.services")
public class ServiceNames {

    private HashMap<String, String> names;

    public HashMap<String, String> getNames() {
        return names;
    }

    public void setNames(HashMap<String, String> names) {
        this.names = names;
    }

    public String getServiceName(String name){
        return this.names.get(name);
    }
}
