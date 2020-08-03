package com.espark.adarsh.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;


@Data
@Table("employee")
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @PrimaryKey
    private Long id;

    private String name;
}
