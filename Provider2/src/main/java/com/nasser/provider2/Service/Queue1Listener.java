package com.nasser.provider2.Service;

import com.nasser.provider2.RequestPayload;
import com.nasser.provider2.Config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class Queue1Listener {

    @RabbitListener(queues = RabbitMQConfig.QUEUE_1)
    public void consumeMessageFromQueue1(RequestPayload payload) {
        System.out.println("Message consumed from queue1: " + payload.getMessage());
    }
}
