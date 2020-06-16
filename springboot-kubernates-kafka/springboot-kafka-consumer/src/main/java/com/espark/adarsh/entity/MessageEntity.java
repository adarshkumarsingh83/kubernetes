package com.espark.adarsh.entity;


import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@ToString
@Table(name = "message")
public class MessageEntity <T>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String messageId;
    private String definition;
    private T data;

    public MessageEntity() {
    }

    public MessageEntity(T message) {
        this.data = message;
    }
}
