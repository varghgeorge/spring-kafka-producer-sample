package com.george.kafka.producer.controllers;

import com.george.kafka.producer.sender.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author George Varghese
 * @version 1.0
 * https://github.com/varghgeorge
 */

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private final Sender sender;

    @Autowired
    KafkaController(Sender sender) {
        this.sender = sender;
    }

    @PostMapping(value = "/publish/message")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        this.sender.send(message);
    }
}
