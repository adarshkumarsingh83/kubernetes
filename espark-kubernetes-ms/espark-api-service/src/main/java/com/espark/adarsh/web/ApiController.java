package com.espark.adarsh.web;

import com.espark.adarsh.bean.ResponseBean;
import com.espark.adarsh.service.ApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@Slf4j
@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    ApiService apiService;

    @GetMapping("/message")
    public Map<String, String> message(@RequestHeader(value = "api-request", required = false) String header) {
        log.info("label=api-controller message() executed");
        Map<String, String> response = this.apiService.getMessages();
        response.put("ESPARK-API-SERVICES", "Hello from Espark Api Service " + header);
        return response;
    }

    @GetMapping("/address/{id}")
    public ResponseBean getAddress(@PathVariable("id") Long id) {
        log.info("label=api-controller getAddress() executed");
        return this.apiService.getAddress(id);
    }

    @GetMapping("/employee/{id}")
    public ResponseBean getEmployee(@PathVariable("id") Long id) {
        log.info("label=api-controller getEmployee() executed");
        return this.apiService.getEmployee(id);
    }

    @GetMapping("/details/{id}")
    public ResponseBean getData(@PathVariable("id") Long id) {
        log.info("label=api-controller getData() executed");
        return this.apiService.getData(id);
    }

    @GetMapping("/details")
    public List<ResponseBean> getAllData() {
        log.info("label=api-controller getAllData() executed");
        return this.apiService.getAllData();
    }

}