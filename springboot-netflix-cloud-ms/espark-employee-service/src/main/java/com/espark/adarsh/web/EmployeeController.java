package com.espark.adarsh.web;

import com.espark.adarsh.entity.Employee;
import com.espark.adarsh.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/message")
    public String message(@RequestHeader(value = "employee-request", required = false) String header) {
        log.info("label=employee-controller message() executed ");
        return "Hello from Espark Employee Service " + header;
    }


    @GetMapping("/employee/{id}")
    public Employee getById(@PathVariable("id") Long id) {
        log.info("label=employee-controller getById() executed ");
        return this.employeeService.getById(id);
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployee() {
        log.info("label=employee-controller getAllEmployee() executed ");
        return this.employeeService.getAllEmployee();
    }

}