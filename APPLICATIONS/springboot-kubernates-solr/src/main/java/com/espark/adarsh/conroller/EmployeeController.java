package com.espark.adarsh.conroller;

import com.espark.adarsh.bean.Employee;
import com.espark.adarsh.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(value = "/employee")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return this.employeeService.saveEmployee(employee);
    }

    @GetMapping(value = "/employee/{id}")
    public Employee getEmployee(@org.springframework.web.bind.annotation.PathVariable("id") String id) {
        Optional<Employee> optionalEmployee = this.employeeService.getEmployee(id);
        return optionalEmployee.isPresent() ? optionalEmployee.get() : null;
    }

    @GetMapping(value = "/employee/name/{name}")
    public List<Employee> getEmployeeByName(@PathVariable("name") String name) {
        List<Employee> employee = this.employeeService.getEmployeeByName(name);
        return employee;
    }

    @GetMapping(value = "/employee/name-like/{name}")
    public  List<Employee> getEmployeeByLikeName(@PathVariable("name") String name) {
        List<Employee> employee = this.employeeService.getEmployeeLikeByName(name);
        return employee;
    }

    @GetMapping(value = "/employee/age/{age}")
    public List<Employee> getEmployeeByName(@PathVariable("age") Integer age) {
        List<Employee> employee = this.employeeService.getEmployeeByAge(age);
        return employee;
    }


}
