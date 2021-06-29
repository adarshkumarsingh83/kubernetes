package com.espark.adarsh.web;

import com.espark.adarsh.service.ApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api")
public class ApplicationController {

    @Autowired
    ApplicationService applicationService;

    @GetMapping("/conf")
    public Map<String, String> getConfiguration() {
       log.info("label=ApplicationController getConfiguration()");
        return this.applicationService.getConfiguration();
    }
}
