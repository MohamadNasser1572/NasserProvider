package com.nasser.providerservice.RabbitMQ.Controller;

import com.fasterxml.jackson.core.util.RequestPayload;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.nasser.providerservice.RabbitMQ.Config.RabbitMQConfig;

@RestController
public class MessageProducerController {
    private final RabbitTemplate rabbitTemplate;

    public MessageProducerController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping("/sendToQueue1")
    public String sendMessageToQueue1(@RequestBody RequestPayload requestPayload) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_1, requestPayload);
        return "Message sent to queue1!";
    }

    @PostMapping("/sendToQueue2")
    public String sendMessageToQueue2(@RequestBody RequestPayload requestPayload) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_2, requestPayload);
        return "Message sent to queue2!";
    }
}
