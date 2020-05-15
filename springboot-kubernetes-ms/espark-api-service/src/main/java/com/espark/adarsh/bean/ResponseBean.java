package com.espark.adarsh.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseBean implements Serializable {

    private Long id;
    private Address address;
    private Employee employee;

    public ResponseBean() {
    }

    public ResponseBean(Long id, Address address) {
        this.id = id;
        this.address = address;
    }

    public ResponseBean(Long id, Employee employee) {
        this.id = id;
        this.employee = employee;
    }

    public ResponseBean(Address address, Employee employee) {
        this.address = address;
        this.employee = employee;
    }

    public ResponseBean(Long id, Address address, Employee employee) {
        this.id = id;
        this.address = address;
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
