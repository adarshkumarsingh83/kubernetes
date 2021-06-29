package com.espark.adarsh.service;

import com.espark.adarsh.entity.Employee;
import com.espark.adarsh.respository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Slf4j
@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee getEmployee(Long id) {
        log.info("label=EmployeeService getEmployee() id={}", id);
        return this.employeeRepository.findById(id).get();
    }

    public List<Employee> getEmployees() {
        log.info("label=EmployeeService getEmployees() ");
        List<Employee> employeeList = new LinkedList<>();
        this.employeeRepository.findAll()
                .forEach(employee -> employeeList.add(employee));
        return employeeList;
    }

    public Employee deleteEmployee(Long id) {
        log.info("label=EmployeeService deleteEmployee() id={}", id);
        Employee employee = this.employeeRepository.findById(id).get();
        this.employeeRepository.delete(employee);
        return employee;
    }

    public Employee persistEmployee(Employee employee) {
        log.info("label=EmployeeService persistEmployee() employee={}", employee);
        return this.employeeRepository.save(employee);
    }
}