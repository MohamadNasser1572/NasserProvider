package com.nasser.provider2.Config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    public static final String QUEUE_1 = "queue1";
    public static final String QUEUE_2 = "queue2";

    @Bean
    public Queue queue1() {
        return new Queue(QUEUE_1);
    }

    @Bean
    public Queue queue2() {
        return new Queue(QUEUE_2);
    }
}
