package com.espark.adarsh.web;

import com.espark.adarsh.entity.Address;
import com.espark.adarsh.service.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class AddressController {


    @Autowired
    AddressService addressService;

    @GetMapping("/message")
    public String message(@RequestHeader(value = "address-request", required = false) String header) {
        log.info("label=address-controller message() executed ");
        return "Hello from Espark Address Service" + header;
    }

    @GetMapping("/address/{id}")
    public Address addressRepository(@PathVariable("id") Long id) {
        log.info("label=address-controller addressRepository() executed ");
        return addressService.getById(id);
    }

    @GetMapping("/addresses")
    public List<Address> getAddress() {
        log.info("label=address-controller getAddress() executed ");
        return addressService.getAddress();
    }

}