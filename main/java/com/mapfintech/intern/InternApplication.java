package com.mapfintech.intern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing

public class InternApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(InternApplication.class);

    public static void main(String[] args) {
        LOGGER.debug("StudentSearchApplication STARTing...");
        SpringApplication.run(InternApplication.class, args);
    }


}