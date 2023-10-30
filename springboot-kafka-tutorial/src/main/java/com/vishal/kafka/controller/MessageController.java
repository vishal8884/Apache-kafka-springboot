package com.vishal.kafka.controller;

import com.vishal.kafka.service.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

    private KafkaProducer kafkaProducer;

    public MessageController(KafkaProducer kafkaProducer){
        this.kafkaProducer = kafkaProducer;
    }

    //http://localhost:8080/api/v1/kafka/publish?message=hello world
    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message){

        try {
            kafkaProducer.sendMessage(message);
        } catch (Exception e){
            System.out.println("Exception occured while sending message to rest API :: "+e.getStackTrace());
            ResponseEntity.internalServerError().body("issue");
        }
        return ResponseEntity.ok("sent to the topic    message = "+message);
    }
}
