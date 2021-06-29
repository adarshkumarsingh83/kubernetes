package com.espark.adarsh.controller;

import com.espark.adarsh.bean.MessageBean;
import com.espark.adarsh.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/consumer")
public class ApplicationController {


    @Autowired
    private MessageService messageService;

    @GetMapping("/message")
    public MessageBean getMessage() {
        MessageBean data = this.messageService.receive();
        log.info("label='get-controller' {}", data);
        return data;
    }

}
