package com.espark.adarsh.repository;

import com.espark.adarsh.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

import java.util.List;

public interface EmployeeRepository extends SolrCrudRepository<Employee, String> {

     List<Employee> findByName(String name);

    @Query("id:*?0* OR name:*?0*")
    Page<Employee> findByCustomQuery(String searchTerm, Pageable pageable);

    @Query(name = "Employee.findByNamedQuery")
    Page<Employee> findByNamedQuery(String searchTerm, Pageable pageable);
}
