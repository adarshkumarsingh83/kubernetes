package com.espark.adarsh.service;

import com.espark.adarsh.bean.Address;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class AddressService {

    @Autowired
    ServiceNames serviceNames;

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getDefaultConfig")
    public HashMap<String, String> getConfig() {
        log.info("label=address-service getConfig() executing ");
        String serviceUrl = "http://"+serviceNames.getServiceName("address")+"/api/config";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("address-request", "ESPARK-HEADER-FROM-API-SERVICE");
        HttpEntity<String> customerHttpEntity = new HttpEntity<String>(httpHeaders);
        ResponseEntity<HashMap<String,String>> responseEntity
                = this.restTemplate.exchange(serviceUrl, HttpMethod.GET, customerHttpEntity,
                new ParameterizedTypeReference<HashMap<String,String>>() {});
        return responseEntity.getBody();
    }

    public HashMap<String, String> getDefaultConfig() {
        log.info("label=address-service getDefaultConfig() executing ");
        return new HashMap<String,String>();
    }

    public void getMessage(HashMap<String, String> response) {
        log.info("label=address-service getMessage() executing");
        String serviceUrl = "http://"+serviceNames.getServiceName("address")+"/api/message";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("address-request", "ESPARK-HEADER-FROM-API-SERVICE");
        HttpEntity<String> customerHttpEntity = new HttpEntity<String>(httpHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(serviceUrl, HttpMethod.GET, customerHttpEntity, String.class);
        response.put("ESPARK-ADDRESS-SERVICE", responseEntity.getBody());
    }

    @HystrixCommand(fallbackMethod = "getDefaultAddress")
    public Address getAddress(Long id) {
        log.info("label=address-service getAddress() executing");
        String serviceUrl = "http://"+serviceNames.getServiceName("address")+"/api/address/" + id;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("address-request", "ESPARK-HEADER-FROM-API-SERVICE");
        HttpEntity<String> customerHttpEntity = new HttpEntity<String>(httpHeaders);
        ResponseEntity<Address> responseEntity = this.restTemplate.exchange(serviceUrl, HttpMethod.GET, customerHttpEntity, Address.class);
        return responseEntity.getBody();
    }

    public Address getDefaultAddress(Long id) {
        log.info("label=address-service getDefaultAddress() executing");
        return new Address(id, null, null, null);
    }

    @HystrixCommand(fallbackMethod = "getDefaultAddresses")
    public List<Address> getAddress() {
        log.info("label=address-service getAddress() executing");
        String serviceUrl = "http://"+serviceNames.getServiceName("address")+"/api/addresses";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("address-request", "ESPARK-HEADER-FROM-API-SERVICE");
        HttpEntity<String> requestHttpEntity = new HttpEntity<String>(httpHeaders);

        ResponseEntity<List<Address>> responseEntity =
                restTemplate.exchange(serviceUrl,
                        HttpMethod.GET, requestHttpEntity,
                        new ParameterizedTypeReference<List<Address>>() {
                        });
        return responseEntity.getBody();
    }

    public List<Address> getDefaultAddresses() {
        log.info("label=address-service getDefaultAddresses() executing");
        return Arrays.asList();
    }
}
