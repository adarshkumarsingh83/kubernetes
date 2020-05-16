package com.espark.adarsh.service;

import com.espark.adarsh.entity.Employee;
import com.espark.adarsh.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class DbInitService {

    @Autowired
    EmployeeRepository employeeRepository;

    @PostConstruct
    public void init() {
        Employee adarsh = new Employee();
        adarsh.setName("adarsh");
        adarsh.setEmail("adarsh@kumar");
        employeeRepository.save(adarsh);

        Employee radha = new Employee();
        radha.setName("radha");
        radha.setEmail("radha@singh");
        employeeRepository.save(radha);
    }

}
