package com.espark.adarsh.respository;

import com.espark.adarsh.entity.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EmployeeRepository extends ElasticsearchRepository<Employee, Long> {
}
