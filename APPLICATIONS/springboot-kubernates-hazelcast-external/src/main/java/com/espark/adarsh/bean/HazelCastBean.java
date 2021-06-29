package com.espark.adarsh.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class HazelCastBean implements Serializable {

    private String key;
    private Object value;

}
