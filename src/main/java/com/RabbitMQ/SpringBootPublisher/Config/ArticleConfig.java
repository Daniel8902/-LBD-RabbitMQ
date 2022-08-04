package com.RabbitMQ.SpringBootPublisher.Config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArticleConfig {
    public static final String QUEUE = "article_queue2";
    public static final String EXCHANGE = "article_exchange2";
    public static final String ROUTING_KEY = "article_routingKey2";



    @Bean
    public Queue queueArticle2() {
        return  new Queue(QUEUE);
    }


    @Bean
    public TopicExchange exchangeArticle2() {
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public Binding bindingArticle2(Queue queueArticle2, TopicExchange exchangeArticle2) {
        return BindingBuilder
                .bind(queueArticle2)

                .to(exchangeArticle2)
                .with(ROUTING_KEY);
    }

}
