package com.vishal.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic getNewTopic(){
        return TopicBuilder
                .name("vishal1")
                .partitions(10)
                .replicas(1)
                .build();  //we can use .partitions to specify the number of partitions
    }

    @Bean
    public NewTopic getJsonNewTopic(){
        return TopicBuilder
                .name("jsonTopic")
                .partitions(10)
                .replicas(1)
                .build();  //we can use .partitions to specify the number of partitions
    }
}
