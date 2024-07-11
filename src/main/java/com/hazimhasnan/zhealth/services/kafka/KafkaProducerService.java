package com.hazimhasnan.zhealth.services.kafka;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaProducerService {
    public static final String TOPIC = "appointment";
    private final KafkaTemplate<String, AppointmentEvent> kafkaTemplate;

    public void sendAppointmentEvent(AppointmentEvent event){
        String key = event.getKey();
        kafkaTemplate.send(TOPIC, key, event);
        log.info("Producer produced the message {}", event);
    }

    @Data
    class AppointmentEvent implements Serializable {
        private String key;
    }
}
