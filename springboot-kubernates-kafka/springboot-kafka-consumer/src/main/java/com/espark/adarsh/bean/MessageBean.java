package com.espark.adarsh.bean;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;


@Data
@ToString
public class MessageBean implements Serializable {

    private Long id;

    private String definition;

    private String data;

    public MessageBean() {
    }

    public MessageBean(String message) {
        this.data = message;
    }
}
