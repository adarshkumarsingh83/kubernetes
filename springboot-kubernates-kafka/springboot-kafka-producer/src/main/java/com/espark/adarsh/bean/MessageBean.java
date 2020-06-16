package com.espark.adarsh.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class MessageBean<T> implements Serializable {

    private String messageId;
    private String definition;
    private T data;

    public MessageBean() {
    }

}
