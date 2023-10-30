package com.vishal.kafka.service;

import com.vishal.kafka.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {

    public static Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics = "jsonTopic", groupId = "myGroup")
    public void consume(User user){
        LOGGER.info(String.format("json message received by consumer "+ user));
    }
}
