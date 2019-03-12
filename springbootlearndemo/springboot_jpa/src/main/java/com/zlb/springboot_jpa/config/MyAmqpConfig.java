package com.zlb.springboot_jpa.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyAmqpConfig {


    @Bean
    public Queue helloQueue() {
        return new Queue("hello");
    }

}
