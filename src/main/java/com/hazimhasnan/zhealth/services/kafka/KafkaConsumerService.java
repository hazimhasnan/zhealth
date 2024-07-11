package com.hazimhasnan.zhealth.services.kafka;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaConsumerService {

    @KafkaListener(topics = "appointment", groupId = "appointmentConsumer")
    public void flightEventConsumer(String eventMessage){

        log.info("Consumer consume the Kafka message -> {}", eventMessage + "noice");
    }

    @Data
    class AppointmentEvent implements Serializable {
        private String key;
    }
}
