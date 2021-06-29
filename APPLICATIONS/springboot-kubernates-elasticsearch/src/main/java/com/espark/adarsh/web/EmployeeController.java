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

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable("id") Long id) {
        log.info("label=EmployeeController getEmployee() id={}", id);
        return this.employeeService.getEmployee(id);
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        log.info("label=EmployeeController getEmployees() ");
        List<Employee> employeeList = new LinkedList<>();
        return this.employeeService.getEmployees();
    }

    @DeleteMapping("/employee/{id}")
    public Employee deleteEmployee(@PathVariable("id") Long id) {
        log.info("label=EmployeeController deleteEmployee() id={}", id);
        return this.employeeService.deleteEmployee(id);
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        log.info("label=EmployeeController createEmployee() employee={}", employee);
        return this.employeeService.persistEmployee(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        log.info("label=EmployeeController updateEmployee() employee={}", employee);
        return this.employeeService.persistEmployee(employee);
    }
}
