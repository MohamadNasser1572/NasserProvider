package com.nasser.provider2.Service;

import com.nasser.provider2.Config.RabbitMQConfig;
import com.nasser.provider2.RequestPayload;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class Queue2CronConsumer {

    private final RabbitTemplate rabbitTemplate;

    public Queue2CronConsumer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Scheduled(fixedRate = 10000)  //every 10 seconds
    public void consumeMessageFromQueue2() {
        RequestPayload payload = (RequestPayload) rabbitTemplate.receiveAndConvert(RabbitMQConfig.QUEUE_2);
        if (payload != null) {
            System.out.println("Message consumed from queue2: " + payload.getMessage());
        }
    }
}
