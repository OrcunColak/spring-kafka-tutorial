package com.colak.springkafkatutorial.service.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * kafka-topics.sh --describe --topic metrics --bootstrap-server localhost:9092
 * kafka-console-producer.sh --topic metrics --bootstrap-server localhost:9092
 *
 */
@Service
@Slf4j
public class MetricsConsumer {

    @KafkaListener(topics = "${app.constant.kafka.metrics-topic-name}",
            groupId = "metrics-consumer-group"
    )
    public void consumeMessage(ConsumerRecord<?, ?> consumerRecord) {
        log.info("MetricsConsumer: {}", consumerRecord.value());
    }
}
