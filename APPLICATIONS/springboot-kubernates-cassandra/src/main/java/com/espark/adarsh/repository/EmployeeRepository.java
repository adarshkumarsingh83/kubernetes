package com.espark.adarsh.repository;

import com.espark.adarsh.entity.Employee;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface EmployeeRepository extends CassandraRepository<Employee, Long> {

}
