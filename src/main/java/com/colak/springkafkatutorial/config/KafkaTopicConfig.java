package com.colak.springkafkatutorial.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Value("${app.constant.kafka.topic-name1}")
    private String metricsTopic1;

    /**
     * See <a href="https://medium.com/@TimvanBaarsen/programmatically-create-kafka-topics-using-spring-kafka-8db5925ed2b1">...</a>
     * Spring Boot will autoconfigure a AdminClientSpring Bean in your application context which will automatically
     * add topics for all beans of type NewTopic.
     */
    @Bean
    public NewTopic metricsTopic() {
        // Spring Kafka version 2.3 introduced a TopicBuilder class to make the creation of such beans even more convenient!
        return TopicBuilder.name(metricsTopic1)
                // By default, the values for both the partitions and replicas in the TopicBuilder are one!
                // For a local development environment, this is a sensible default
                // Note : If the topic exists and requested number of partitions is bigger, the admin increases the number of partitions
                .partitions(1)
                .replicas(1)
                // cleanup policy is compact
                .compact()
                .config(TopicConfig.COMPRESSION_TYPE_CONFIG, "zstd")
                .build();
    }
}
