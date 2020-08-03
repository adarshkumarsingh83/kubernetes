package com.espark.adarsh.config;

import com.datastax.driver.core.exceptions.NoHostAvailableException;
import com.datastax.driver.core.exceptions.TransportException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;

@Slf4j
public class CassandraClusterConnectionRetryingService extends CassandraClusterFactoryBean {


    @Override
    public void afterPropertiesSet() throws Exception {
        connect();
    }

    private void connect() throws Exception {
        try {
            super.afterPropertiesSet();
        } catch (TransportException | IllegalArgumentException | NoHostAvailableException e) {
            log.warn("label=CassandraClusterConnectionRetryingService " +
                    "Retrying connection in 10 seconds ex={}", e.getMessage());
            sleep();
            connect();
        }
    }

    private void sleep() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ignored) {
        }
    }
}