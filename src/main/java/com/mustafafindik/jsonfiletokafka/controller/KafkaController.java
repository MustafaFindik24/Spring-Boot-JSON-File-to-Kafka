package com.mustafafindik.jsonfiletokafka.controller;

import com.mustafafindik.jsonfiletokafka.service.JsonFileReader;
import com.mustafafindik.jsonfiletokafka.service.KafkaProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/json")
public class KafkaController {



    private final JsonFileReader jsonFileReaderService;
    private final KafkaProducer kafkaProducerService;

    public KafkaController(JsonFileReader jsonFileReaderService, KafkaProducer kafkaProducerService) {
        this.jsonFileReaderService = jsonFileReaderService;
        this.kafkaProducerService = kafkaProducerService;
    }

    @PostMapping
    public void sendToKafka() throws IOException {
        List<Object> dataList = jsonFileReaderService.readJsonFile();
        kafkaProducerService.sendJsonData(dataList);
    }
}
