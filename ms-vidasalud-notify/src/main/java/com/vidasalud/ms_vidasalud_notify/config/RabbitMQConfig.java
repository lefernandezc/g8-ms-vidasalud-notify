package com.vidasalud.ms_vidasalud_notify.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_EMAIL = "q.cmd.email";
    public static final String QUEUE_ADMISSION = "q.cmd.admission";
    public static final String QUEUE_RECORD = "q.cmd.record";

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}