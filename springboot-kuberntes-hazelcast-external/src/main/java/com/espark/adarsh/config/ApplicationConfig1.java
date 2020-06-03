/*
package com.espark.adarsh.config;

import com.espark.adarsh.bean.HazelCastBean;
import com.hazelcast.config.*;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.logging.LogEvent;
import com.hazelcast.logging.LogListener;
import com.hazelcast.logging.LoggingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Level;

@Slf4j
@Configuration
public class ApplicationConfig1 {

    @Bean
    public Config hazelCastConfig(){
        Config config= new Config()
                .setInstanceName("hazelcast-instance")
                .addMapConfig(
                        new MapConfig()
                                .setName("data-store")
                                .setMaxSizeConfig(new MaxSizeConfig(200, MaxSizeConfig.MaxSizePolicy.FREE_HEAP_SIZE))
                                .setEvictionPolicy(EvictionPolicy.LRU)
                                .setTimeToLiveSeconds(20))
                .setProperty("hazelcast.logging.type","slf4j");


        config.getSerializationConfig().getSerializerConfigs().add(
                new SerializerConfig().
                        setTypeClass(HazelCastBean.class).
                        setImplementation(new HazelCastBeanSerializer()));

        NetworkConfig network = config.getNetworkConfig();
        network.setPort(5701).setPortCount(20);
        network.setPortAutoIncrement(true);
        JoinConfig join = network.getJoin();
        join.getMulticastConfig().setEnabled(false);
        join.getTcpIpConfig()
                .addMember("machine1")
                .addMember("hazelcast")
                .addMember("localhost").setEnabled(true);
        return config;
    }

    @Bean
    public HazelcastInstance hazelcastInstance() {
        HazelcastInstance instance= Hazelcast.newHazelcastInstance(hazelCastConfig());
        LogListener listener = new LogListener() {
            public void log( LogEvent logEvent ) {
                log.info(logEvent.toString());
            }
        };
        LoggingService loggingService = instance.getLoggingService();
        loggingService.addLogListener( Level.ALL, listener );
        return instance;
    }


}

*/
