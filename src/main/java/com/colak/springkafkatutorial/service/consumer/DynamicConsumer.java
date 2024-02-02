package com.colak.springkafkatutorial.service.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * See <a href="https://medium.com/@ravisharma911993/kafka-broadcasting-messages-without-consumer-groups-5a374fcfb7bc">...</a>
 * DynamicConsumer has a new groupId every time
 */
@Service
@Slf4j
public class DynamicConsumer {

    @KafkaListener(topics = "${app.constant.kafka.topic-name1}",
            groupId = "consumerGroup-" + "#{T(java.util.UUID).randomUUID()}"
    )
    public void consumeMessage(ConsumerRecord<?, ?> consumerRecord) {
        log.info("DynamicConsumer: {}", consumerRecord.value());
    }
}
