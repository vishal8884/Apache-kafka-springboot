package com.vishal.kafka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    public static Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "vishal1", groupId = "myGroup")
    public void consume(String message){
        LOGGER.info(String.format("message received by consumer "+ message));
    }
}
