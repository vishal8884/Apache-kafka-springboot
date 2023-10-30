package com.springboot;

import com.launchdarkly.eventsource.EventSource;
import com.launchdarkly.eventsource.StreamException;
import com.launchdarkly.eventsource.background.BackgroundEventHandler;
import com.launchdarkly.eventsource.background.BackgroundEventSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Service
public class WikimediaChangesProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(WikimediaChangesProducer.class);

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;


    public void sendMessage() throws StreamException, InterruptedException {
        LOGGER.info("Send Message method called");

        String topic = "wikimedia_recentchange";
        String url = "https://stream.wikimedia.org/v2/stream/recentchange";

        //to read realtime stream data from wikimedia we use event source
        //that message will be sent to kafka topic
        BackgroundEventHandler eventHandler = new WikiMediaChangesHandler(kafkaTemplate,topic);

        URI uriUrl = URI.create(url);
        EventSource.Builder eventSourceBuilder = new EventSource.Builder(uriUrl);

        BackgroundEventSource eventSource = new BackgroundEventSource.Builder(eventHandler,eventSourceBuilder).build();

        eventSource.start();
        TimeUnit.MINUTES.sleep(10);
    }

}
