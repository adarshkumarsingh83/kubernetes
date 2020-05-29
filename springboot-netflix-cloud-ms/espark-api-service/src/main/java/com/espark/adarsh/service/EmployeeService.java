package com.espark.adarsh.service;

import com.espark.adarsh.bean.Employee;
import com.espark.adarsh.config.ServiceNames;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Slf4j
@Service
public class EmployeeService {

    @Autowired
    ServiceNames serviceNames;

    @Autowired
    RestTemplate restTemplate;

    public void getMessage(HashMap<String, String> response) {
        log.info("label=employee-service getMessage() executing");
        String serviceUrl = "http://"+serviceNames.getServiceName("employee")+"/api/message";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("employee-request", "ESPARK-HEADER-FROM-API-SERVICE");
        HttpEntity<String> customerHttpEntity = new HttpEntity<String>(httpHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(serviceUrl, HttpMethod.GET, customerHttpEntity, String.class);
        response.put("ESPARK-EMPLOYEE-SERVICE", responseEntity.getBody());
    }

    @HystrixCommand(fallbackMethod = "getDefaultEmployee")
    public Employee getEmployee(Long id) {
        log.info("label=employee-service getEmployee() executing");
        String serviceUrl = "http://"+serviceNames.getServiceName("employee")+"/api/employee/" + id;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("employee-request", "ESPARK-HEADER-FROM-API-SERVICE");
        HttpEntity<String> customerHttpEntity = new HttpEntity<String>(httpHeaders);
        ResponseEntity<Employee> responseEntity = restTemplate.exchange(serviceUrl, HttpMethod.GET, customerHttpEntity, Employee.class);
        return responseEntity.getBody();
    }

    public Employee getDefaultEmployee(Long id) {
        log.info("label=employee-service getDefaultEmployee() executing");
        return new Employee(id, null, null, null);
    }

    @HystrixCommand(fallbackMethod = "getDefaultEmployees")
    public List<Employee> getEmployees() {
        log.info("label=employee-service getEmployees() executing");

        String serviceUrl = "http://"+serviceNames.getServiceName("employee")+"/api/employees";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("employee-request", "ESPARK-HEADER-FROM-API-SERVICE");
        HttpEntity<String> requestHttpEntity = new HttpEntity<String>(httpHeaders);

        ResponseEntity<List<Employee>> responseEntity =
                restTemplate.exchange(serviceUrl, HttpMethod.GET, requestHttpEntity,
                        new ParameterizedTypeReference<List<Employee>>() {
                        });
        return responseEntity.getBody();
    }

    public List<Employee> getDefaultEmployees() {
        log.info("label=employee-service getDefaultEmployees() executing");
        return Arrays.asList();
    }
}

