package com.nasser.providerservice.RabbitMQ;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue queue1() {
        return new Queue("queue1", false);
    }

    @Bean
    public Queue queue2() {
        return new Queue("queue2", false);
    }
}
