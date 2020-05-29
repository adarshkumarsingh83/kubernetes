package com.espark.adarsh.service;

import com.espark.adarsh.entity.Employee;
import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployee();

    Employee createEmployee(Employee employee);

    Employee getEmployeeById(String empId);

    Employee updateEmployee(String empId, Employee employeeDetails);

    Employee deleteEmployee( String empId);
}
