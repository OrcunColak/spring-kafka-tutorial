package com.colak.springkafkatutorial.service.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.common.TopicPartition;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Collections;

/**
 * See <a href="https://medium.com/@priyankapruthe/mastering-kafka-unveiling-high-throughput-availability-scalability-and-replayability-with-785d64125f78">...</a>
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ReplayService {

    private final ConsumerFactory<?, ?> consumerFactory;

    public void replayFromOffset(String topic, int partition, long offset) {
        try (Consumer<?, ?> consumer = consumerFactory.createConsumer()) {
            consumer.assign(Collections.singletonList(new TopicPartition(topic, partition)));
            consumer.seek(new TopicPartition(topic, partition), offset);

            while (true) {
                ConsumerRecords<?, ?> records = consumer.poll(Duration.ofSeconds(1));
                if (records.isEmpty()) {
                    break;
                }
                for (ConsumerRecord<?, ?> consumerRecord : records) {
                    log.info("ReplayService: {}", consumerRecord.value());
                }
            }
        }
    }
}
