package com.espark.adarsh.service;

import com.espark.adarsh.bean.MessageBean;
import com.espark.adarsh.configuration.RabbitMQProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MessageServiceImpl implements MessageService {


    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Autowired
    RabbitMQProperties rabbitMQProperties;


    @Override
    public MessageBean receive() {
        MessageBean message = (MessageBean) rabbitTemplate.receiveAndConvert(rabbitMQProperties.getQueue());
        if (message == null) {
            message = new MessageBean("admin", "welcome to espark message is empty");
        }
        log.info("label='receive ' {}", message);
        return message;
    }
}
