package com.espark.adarsh.entity;


import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@ToString
@Table(name = "message_entity")
public class MessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String definition;

    private String data;

    public MessageEntity() {
    }

    public MessageEntity(String message) {
        this.data = message;
    }

    public MessageEntity(com.espark.adarsh.bean.MessageBean message) {
        this.data = message.getData();
        this.id = message.getId();
        this.definition = message.getDefinition();
    }
}
