package com.colak.springkafkatutorial.service.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Send messages to kafka
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class MetricsTopicProducer {

    @Value("${app.constant.kafka.metrics-topic-name}")
    private String topicName;

    private final KafkaTemplate<String, String> kafkaTemplate;


    public void sendMessage(String message) {
        kafkaTemplate.send(topicName, message);
        log.info("Finished {}", topicName);
    }
}
