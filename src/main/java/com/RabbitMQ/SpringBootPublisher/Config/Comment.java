package com.RabbitMQ.SpringBootPublisher.Config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Comment {
    public static final String QUEUE = "comment_queue";
    public static final String EXCHANGE = "coment_exchange";
    public static final String ROUTING_KEY = "comment_routingKey";



    @Bean
    public Queue queueComment() {
        return  new Queue(QUEUE);
    }


    @Bean
    public TopicExchange exchangeComment() {
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public Binding bindingComment(Queue queueComment, TopicExchange exchangeComment) {
        return BindingBuilder
                .bind(queueComment)

                .to(exchangeComment)
                .with(ROUTING_KEY);
    }
}
