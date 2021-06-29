package com.espark.adarsh.service;

import com.espark.adarsh.bean.MessageBean;
import com.espark.adarsh.configuration.RabbitMQProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Slf4j
@Service
public class MessageServiceImpl implements MessageService {


    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    RabbitMQProperties rabbitMQProperties;


    @Override
    public void send(MessageBean message) {
        log.info("label='send ' {}", message);
        if (!StringUtils.isEmpty(message)) {
            this.rabbitTemplate.convertAndSend(rabbitMQProperties.getExchange(), rabbitMQProperties.getRoutingKey(), message);
        }
    }
}
