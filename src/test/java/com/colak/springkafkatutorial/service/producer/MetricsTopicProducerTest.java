package com.colak.springkafkatutorial.service.producer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MetricsTopicProducerTest {
    @Autowired
    public MetricsTopicProducer metricsTopicProducer;

    @Test
    void testSendMessage() {
        metricsTopicProducer.sendMessage("message");
    }
}
