package com.espark.adarsh.service;

import com.espark.adarsh.bean.MessageBean;
import com.espark.adarsh.entity.MessageEntity;
import com.espark.adarsh.repository.MessageEntityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class ConsumerService {

    @Autowired
    MessageEntityRepository messageEntityRepository;


    @KafkaListener(topics = "${spring.kafka.consumer.topic}",
            groupId = "${spring.kafka.consumer.group}",
            containerFactory = "kafkaListenerContainerFactory")
    public void onReceiving(String message) {
        log.info("label=ConsumerService consume() message={}", message);
    }


    @KafkaListener(topics = "${spring.kafka.consumer.topic}",
            groupId = "${spring.kafka.consumer.groupMessage}",
            containerFactory = "messageKafkaListenerFactory")
    public void onReceiving(MessageBean messageBean, @Header(KafkaHeaders.OFFSET) Integer offset,
                            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
                            @Header(KafkaHeaders.RECEIVED_TOPIC) String message) {
        log.info("label=ConsumerService consume() messageBean={}", messageBean);
        if (messageBean != null) {
            MessageEntity messageEntity = this.messageEntityRepository.save(new MessageEntity(messageBean));
            log.info("label=ConsumerService consume() saved messageEntity={}", messageEntity);
        }
    }


    public MessageEntity getMessage(Long id) {
        log.info("label=ConsumerService getMessage() id={}", id);
        return this.messageEntityRepository.findById(id).get();
    }

    public List<MessageEntity> getAllMessage() {
        log.info("label=ConsumerService getAllMessage()");
        List<MessageEntity> messageEntities = new LinkedList<>();
        this.messageEntityRepository
                .findAll()
                .forEach(messageEntity -> messageEntities.add(messageEntity));
        return messageEntities;
    }


    public MessageEntity deleteMessage(Long id) {
        log.info("label=ConsumerService deleteMessage() id={}", id);
        MessageEntity messageEntity = this.messageEntityRepository.findById(id).get();
        this.messageEntityRepository.delete(messageEntity);
        return messageEntity;
    }

}
