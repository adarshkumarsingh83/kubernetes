package com.espark.adarsh.respository;


import com.espark.adarsh.bean.Employee;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.data.solr.repository.Query;

import java.util.List;

public interface EmployeeRepository extends SolrCrudRepository<Employee, String> {

    @Query("name:?0")
    List<Employee> findByName(String name);


    @Query("name:?0")
    List<Employee> findByNameLike(String name);

    @Query("age:?0")
    List<Employee> findByAge(Integer age);
}