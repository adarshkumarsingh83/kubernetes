package com.espark.adarsh.entity;


import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;


@Data
@Table("employee")
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @PrimaryKey
    private Long id;

    private String name;
}
