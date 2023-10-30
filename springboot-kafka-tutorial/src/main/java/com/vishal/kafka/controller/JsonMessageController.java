package com.vishal.kafka.controller;

import com.vishal.kafka.model.User;
import com.vishal.kafka.service.JsonKafkaProducer;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka/json")
public class JsonMessageController {

    @Autowired
    private JsonKafkaProducer jsonKafkaProducer;

    @PostMapping(value = "/publish")
    public ResponseEntity<String> publishUserToKafka(@RequestBody User user){

        try{
            jsonKafkaProducer.sendMessage(user);
        } catch (Exception e) {
            ResponseEntity.internalServerError().body("Exception occured");
        }

        return ResponseEntity.ok("JSON message sent successfully");
    }
}
