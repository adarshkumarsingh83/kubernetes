package com.espark.adarsh.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

@Data
@Document(indexName = "epsark-index", createIndex = true)
public class Employee implements Serializable {

    @Id
    private Integer id;
    private String name;
}
