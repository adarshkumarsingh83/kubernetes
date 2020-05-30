package com.espark.adarsh.controller;

import com.espark.adarsh.bean.MessageBean;
import com.espark.adarsh.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/producer")
public class ApplicationController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/message")
    public void sendMessage(@RequestBody MessageBean message) {
        log.info("label='send-controller' {}", message);
        this.messageService.send(message);
    }

}
