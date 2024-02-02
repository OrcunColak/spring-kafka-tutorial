package com.colak.springkafkatutorial.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;

import static org.mockito.Mockito.*;

@SpringBootTest
class MetricsTopicProducerTest {
    @Autowired
    public MetricsTopicProducer metricsTopicProducer;

    @Test
    void testSendMessage() {
        metricsTopicProducer.sendMessage("message");
    }
}
