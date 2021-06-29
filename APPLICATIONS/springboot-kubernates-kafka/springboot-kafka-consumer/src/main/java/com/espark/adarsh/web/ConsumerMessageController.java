package com.espark.adarsh.web;

import com.espark.adarsh.entity.MessageEntity;
import com.espark.adarsh.service.ConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class ConsumerMessageController {

    @Autowired
    ConsumerService consumerService;


    @GetMapping("/messages")
    public List<MessageEntity> getAllMessages() {
        log.info("label=ConsumerMessageController getAllMessages()");
        return this.consumerService.getAllMessage();
    }

    @GetMapping("/message/{id}")
    public MessageEntity getMessages(@PathVariable("id") Long id) {
        log.info("label=ConsumerMessageController getMessages()");
        return this.consumerService.getMessage(id);
    }

    @DeleteMapping("/messages/{id}")
    public MessageEntity deleteMessages(@PathVariable("id") Long id) {
        log.info("label=ConsumerMessageController deleteMessages()");
        return this.consumerService.deleteMessage(id);
    }
}
