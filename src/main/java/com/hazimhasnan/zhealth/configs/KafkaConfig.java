package com.hazimhasnan.zhealth.configs;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;

import java.io.Serializable;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic topic() {
        return TopicBuilder.name("appointment")
                .partitions(10)
                .replicas(1)
                .build();
    }

    @Bean
    public ApplicationRunner runner(KafkaTemplate<String, String> template) {
        return args -> {
            template.send("appointment","hazim");
        };
    }

    @Data
    @AllArgsConstructor
    class AppointmentEvent implements Serializable {
        private String key;
    }
}
