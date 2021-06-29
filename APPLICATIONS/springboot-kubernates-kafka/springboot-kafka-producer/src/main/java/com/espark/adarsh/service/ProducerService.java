package com.espark.adarsh.service;

import com.espark.adarsh.bean.MessageBean;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProducerService {

    @Value("${spring.kafka.producer.topic}")
    private String kafkaTopic;

    @Autowired
    KafkaTemplate<String, MessageBean> kafkaTemplate;

    public String sendMessage(MessageBean messageBean) {
        try {
            SendResult<String, MessageBean> sendResult = kafkaTemplate.send(kafkaTopic, messageBean).get();
            RecordMetadata recordMetadata = sendResult.getRecordMetadata();
            log.info("label=ProducerService sendMessage() topic={}, partition={}, offset={}, messageBean={}",
                    recordMetadata.topic(), recordMetadata.partition(), recordMetadata.offset(), messageBean);
            return "MESSAGE POSTED SUCCESSFULLY IN KAFKA QUEUE";
        } catch (Exception e) {
            log.error("label=ProducerService error={}", e.getMessage());
        }
        return "MESSAGE POSTING UN-SUCCESSFULLY";
    }
}
