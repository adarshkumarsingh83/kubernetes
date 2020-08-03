package com.espark.adarsh.service;

import com.espark.adarsh.entity.Employee;
import com.espark.adarsh.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee save(Employee entity) {
        log.info("label=EmployeeService save()");
        return this.employeeRepository.save(entity);
    }

    public Employee update(Long id, Employee entity) {
        log.info("label=EmployeeService update()");
        return this.employeeRepository.save(entity);
    }

    public Employee delete(Long id) {
        log.info("label=EmployeeService delete()");
        Employee employee = this.employeeRepository.findById(id).get();
        this.employeeRepository.delete(employee);
        return employee;
    }

    public Employee get(Long id) {
        log.info("label=EmployeeService get()");
        return this.employeeRepository.findById(id).get();
    }

    public List getAll() {
        log.info("label=EmployeeService getAll()");
        return this.employeeRepository.findAll();
    }
}
