package com.george.kafka.producer.sender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @author George Varghese
 * @version 1.0
 * https://github.com/varghgeorge
 */

@Service
public class Sender {

    private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);

    @Value("${spring.kafka.producer.topic}")
    private String messageTopic;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(String message) {
        LOGGER.info("sending message='{}'", message);
        kafkaTemplate.send(messageTopic, message);
    }
}
