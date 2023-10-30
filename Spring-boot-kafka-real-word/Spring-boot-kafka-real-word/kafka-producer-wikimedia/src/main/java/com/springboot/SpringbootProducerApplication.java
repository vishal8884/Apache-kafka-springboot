package com.springboot;

import com.launchdarkly.eventsource.StreamException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootProducerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootProducerApplication.class);
    }

    @Autowired
    private WikimediaChangesProducer wikimediaChangesProducer;

    @Override
    public void run(String ...args) throws InterruptedException, StreamException {
        wikimediaChangesProducer.sendMessage();
    }
}
