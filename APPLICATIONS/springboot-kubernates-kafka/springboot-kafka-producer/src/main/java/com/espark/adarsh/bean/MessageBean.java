package com.espark.adarsh.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class MessageBean implements Serializable {

    private Long id;
    private String definition;
    private String data;

    public MessageBean() {
    }

}
