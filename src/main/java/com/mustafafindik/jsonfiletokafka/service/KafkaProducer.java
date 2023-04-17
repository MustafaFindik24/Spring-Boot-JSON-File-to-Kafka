package com.mustafafindik.jsonfiletokafka.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KafkaProducer {
    @Value("${mustafafindik.kafka.topic}")
    private String topic;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendJsonData(List<Object> dataList) {
        for (Object data : dataList) {
            kafkaTemplate.send(topic, data);
        }
    }
}
