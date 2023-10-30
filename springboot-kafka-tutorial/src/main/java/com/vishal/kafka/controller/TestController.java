package com.vishal.kafka.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {



    @GetMapping("/Test")
    public ResponseEntity<String> helloWorld(){
        return ResponseEntity.ok().body("Hello World");
    }

}
