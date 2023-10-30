package com.vishal.kafka.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class KafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;  //instead of @Autowired constructor injection is done



    public void sendMessage(String message) {
        LOGGER.info("message being sent"+message);
        kafkaTemplate.send("vishal1", message);
    }
}
