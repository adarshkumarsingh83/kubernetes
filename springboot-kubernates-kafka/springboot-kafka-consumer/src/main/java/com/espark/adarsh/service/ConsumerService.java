package com.espark.adarsh.service;

import com.espark.adarsh.entity.MessageEntity;
import com.espark.adarsh.repository.MessageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.*;

@Slf4j
@Service
public class ConsumerService {

    @Autowired
    MessageRepository messageRepository;


    @KafkaListener(topics = "${spring.kafka.consumer.topic}",
            groupId = "${spring.kafka.consumer.group}")
    public void onReceiving(MessageEntity messageBean, @Header(KafkaHeaders.OFFSET) Integer offset,
                            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
                            @Header(KafkaHeaders.RECEIVED_TOPIC) String message) {
        log.info("label=ConsumerService consume() message={}", messageBean);
        if (!StringUtils.isEmpty(message)) {
            messageBean = this.messageRepository.save(messageBean);
            log.info("label=ConsumerService consume() saved messageBean={}", messageBean);
        }
    }

    public MessageEntity getMessage(String id) {
        log.info("label=ConsumerService getMessage() id={}", id);
        return this.messageRepository.findById(id).get();
    }

    public List<MessageEntity> getAllMessage() {
        log.info("label=ConsumerService getAllMessage()");
        List<MessageEntity> messageEntities = new LinkedList<>();
        this.messageRepository
                .findAll()
                .forEach(messageEntity -> messageEntities.add(messageEntity));
        return messageEntities;
    }


    public MessageEntity deleteMessage(String id) {
        log.info("label=ConsumerService deleteMessage() id={}", id);
        MessageEntity messageEntity = this.messageRepository.findById(id).get();
        this.messageRepository.delete(messageEntity);
        return messageEntity;
    }

}
