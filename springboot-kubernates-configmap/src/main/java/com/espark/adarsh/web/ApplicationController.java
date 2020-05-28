package com.espark.adarsh.web;

import com.espark.adarsh.config.ApplicationPropsConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api")
public class ApplicationController {

    @Autowired
    ApplicationPropsConfig applicationPropsConfig;

    @GetMapping("/message")
    public Map<String, String> getMessage() {
        log.info("label=ApplicationController getMessage() executed ");
        return new HashMap<String, String>() {
            {
                put("message", applicationPropsConfig.getMessage());
                put("name", applicationPropsConfig.getName());
            }
        };
    }

}
