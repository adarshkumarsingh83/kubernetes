package com.espark.adarsh.config;

import com.espark.adarsh.bean.MessageBean;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class ApplicationConfig {

    @Value("${spring.kafka.consumer.group}")
    String kafkaGroup;

    @Value("${spring.kafka.consumer.groupMessage}")
    String kafkaMessageGroup;


    @Value("${spring.kafka.consumer.host}")
    String kafkaHost;

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, MessageBean> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, MessageBean> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConcurrency(1);
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

    @Bean
    public ConsumerFactory<String, MessageBean> consumerFactory() {
        Map<String, Object> properties = new HashMap<>();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaHost);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, kafkaGroup);
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(properties);
    }


    @Bean
    public ConsumerFactory<String, MessageBean> messageConsumerFactory() {
        Map<String, Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaHost);
        config.put(ConsumerConfig.GROUP_ID_CONFIG, kafkaMessageGroup);
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        config.put(JsonDeserializer.TRUSTED_PACKAGES, "com.espark.adarsh.bean.MessageBean");
        return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(),
                new JsonDeserializer<>(MessageBean.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, MessageBean> messageKafkaListenerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, MessageBean> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConcurrency(1);
        factory.setConsumerFactory(messageConsumerFactory());
        return factory;
    }

}
