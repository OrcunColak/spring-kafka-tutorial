package com.colak.springkafkatutorial.service.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

/**
 * See <a href="https://medium.com/@ravisharma911993/kafka-broadcasting-messages-without-consumer-groups-5a374fcfb7bc">...</a>
 * This consumer is designed to read the latest message only
 */
@Service
@Slf4j
public class StandaloneConsumer {

    // If you don’t provide a group.id for your Kafka consumer, the consumer operates in a "simple" mode.
    // Each consumer works independently and does not coordinate with other consumers.
    // With empty group.id offset management becomes the responsibility of the application.
    // This means you need to handle the storage of offsets yourself.
    // During polling, you’ll have to maintain and retrieve the offset information from a storage system,
    // then request Kafka to deliver messages from that offset onward. This introduces a layer of complexity to the process.
    // But if we want to simply process the latest message and things will work fine.
    // There are two properties of the consumer that you need to modify to make the standalone consumer work.
    //
    // auto.offset.reset: The value of this property will be “latest”. Using “latest” the consumer starts reading from the latest offset, i.e., the end of the partition. The other values are “earliest”, “none” & “error”.
    // enable.auto.offset: This will be false as we are not committing any offset.
    @KafkaListener(
            groupId = "",
            topicPartitions = {@TopicPartition(topic = "${app.constant.kafka.topic-name1}", partitions = "0")}
    )
    public void consumeMessage(ConsumerRecord<?, ?> consumerRecord) {
        log.info("StandaloneConsumer: {}", consumerRecord.value());
    }
}