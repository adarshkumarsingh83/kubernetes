package com.espark.adarsh;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class KubernetesElkApplication {

    public static void main(String[] args) {
        SpringApplication.run(KubernetesElkApplication.class, args);
        log.info("label=KubernetesElkApplication main() started execution  ");
    }

}
