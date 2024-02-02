package com.colak.springkafkatutorial.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Value("${app.constant.kafka.topic-name1}")
    private String metricsTopic1;

    @Bean
    public NewTopic metricsTopic() {
        return TopicBuilder.name(metricsTopic1).build();
    }
}
