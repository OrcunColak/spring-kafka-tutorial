package com.colak.springkafkatutorial.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Read messages from container
 * kafka-console-consumer.sh  --topic metric1 --from-beginning --bootstrap-server localhost:9092
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class MetricsTopicProducer {

    @Value("${app.constant.kafka.topic-name1}")
    private String topicName;

    private final KafkaTemplate<String, String> kafkaTemplate;


    public void sendMessage(String message) {
        kafkaTemplate.send(topicName, message);
        log.info("Finished {}", topicName);
    }
}
