package com.espark.adarsh.web;

import com.espark.adarsh.entity.Employee;
import com.espark.adarsh.service.EmployeeService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@Slf4j
@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable("id") Long id) {
        log.info("label=EmployeeController getEmployee()");
        return this.employeeService.get(id);
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        log.info("label=EmployeeController getEmployees()");
        return this.employeeService.getAll();
    }

    @DeleteMapping("/employee/{id}")
    public Employee deleteEmployee(@PathVariable("id") Long id) {
        return this.employeeService.delete(id);
    }

    @PostMapping("/employee")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return this.employeeService.save(employee);
    }

    @PutMapping("/employee/{id}")
    public Employee updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
        return this.employeeService.update(id, employee);
    }

}
