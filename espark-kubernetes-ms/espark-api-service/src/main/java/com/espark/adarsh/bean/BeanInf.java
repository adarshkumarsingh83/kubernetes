package com.espark.adarsh.bean;

public interface BeanInf {

    public enum Type {
        ADDRESS, EMPLOYEE;
    }

    public Long getId();

    public Type getType();

}
