package com.espark.adarsh.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "espark_employee", type = "employee")
public class Employee {

    @Id
    private Long id;
    private String name;

}
