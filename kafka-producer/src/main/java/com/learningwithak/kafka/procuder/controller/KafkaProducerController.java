package com.learningwithak.kafka.procuder.controller;

import com.learningwithak.kafka.procuder.service.ProducerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaProducerController {

    private final ProducerService producerService;

    public KafkaProducerController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @GetMapping("/publish")
    public String publishMessage(@RequestParam("message") String message) {
        producerService.sendMessage("my-demo-topic", message);
        return "Message published successfully!";
    }
}

