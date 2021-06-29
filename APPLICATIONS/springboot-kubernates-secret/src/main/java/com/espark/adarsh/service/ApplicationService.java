package com.espark.adarsh.service;

import com.espark.adarsh.config.ApplicationPropConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class ApplicationService {

    @Autowired
    ApplicationPropConfig applicationPropConfig;

    public Map<String,String> getConfiguration(){
        log.info("label=ApplicationService getConfiguration()");
        return new HashMap<String,String>(){
            {
                put("EMAIL",applicationPropConfig.getEmail());
                put("PHONE",applicationPropConfig.getPhone());
                put("SECRET",applicationPropConfig.getSecretId());
            }
        };
    }
}
