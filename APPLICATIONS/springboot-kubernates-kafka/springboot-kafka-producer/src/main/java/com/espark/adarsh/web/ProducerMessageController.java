package com.espark.adarsh.web;

import com.espark.adarsh.bean.MessageBean;
import com.espark.adarsh.service.ProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
public class ProducerMessageController {

    @Autowired
    ProducerService producerService;

    @PostMapping("/message")
    public String postMessage( @RequestBody MessageBean message) {
        log.info("label=ProducerMessageController postMessage() message={}", message);
        return this.producerService.sendMessage(message);
    }
}
