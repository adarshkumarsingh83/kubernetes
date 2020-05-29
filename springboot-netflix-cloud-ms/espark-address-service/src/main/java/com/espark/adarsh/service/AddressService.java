package com.espark.adarsh.service;

import com.espark.adarsh.entity.Address;
import com.espark.adarsh.respository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    public Address getById(Long id) {
        return this.addressRepository.findById(id).get();
    }

    public List<Address> getAddress() {
        List<Address> addressList = new LinkedList<>();
        this.addressRepository.findAll().forEach(address -> addressList.add(address));
        return addressList;
    }

}
