package com.espark.adarsh.config;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import net.logstash.logback.appender.LogstashTcpSocketAppender;
import net.logstash.logback.encoder.LogstashEncoder;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Configuration
@ConditionalOnProperty(
        value = "spring.logstash.enabled"
        , havingValue = "true"
        , matchIfMissing = true)
public class LogstashConfiguration {

    private static final String TCP_APPENDER_NAME = "LOGSTASH";
    private static final Integer TCP_WRITE_BUFFER_SIZE = 81920;

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${spring.logstash.url}")
    String url = "";

    /**
     * Executed after dependency injection is done to perform any initialization
     */
    @PostConstruct
    public void init() {
        log.debug("label=LogstashConfiguration init()");
    }


    @Bean
    public LogstashTcpSocketAppender tcpSocketAppender() {

        log.debug("label=LogstashConfiguration tcpSocketAppender()");
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        LogstashTcpSocketAppender logstashTcpSocketAppender = new LogstashTcpSocketAppender();
        logstashTcpSocketAppender.setName(TCP_APPENDER_NAME);
        logstashTcpSocketAppender.setContext(loggerContext);
        logstashTcpSocketAppender.addDestination(url);
        logstashTcpSocketAppender.setWriteBufferSize(TCP_WRITE_BUFFER_SIZE);
        logstashTcpSocketAppender.setEncoder(logstashEncoder(loggerContext));
        logstashTcpSocketAppender.start();
        loggerContext.getLogger(Logger.ROOT_LOGGER_NAME).addAppender(logstashTcpSocketAppender);
        return logstashTcpSocketAppender;
    }


    @Bean
    public LogstashEncoder logstashEncoder(LoggerContext loggerContext) {
        log.debug("label=LogstashConfiguration logstashEncoder()");
        LogstashEncoder encoder = new LogstashEncoder();
        encoder.setContext(loggerContext);
        encoder.setIncludeContext(true);
        encoder.setCustomFields(setAttributes());
        encoder.start();
        return encoder;
    }


    private String setAttributes() {
        log.debug("label=LogstashConfiguration setAttributes()");
        Map<String, String> additionalConfiguration = new HashMap<>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            additionalConfiguration.put("ESPARK_APPLICATION", applicationName);
            return objectMapper.writeValueAsString(additionalConfiguration);
        } catch (Exception jsonException) {
            log.error("label=LogstashConfiguration setAttributes() method could not set the additional attributes"
                    + jsonException.getMessage());
        }
        return "{}";
    }


}
