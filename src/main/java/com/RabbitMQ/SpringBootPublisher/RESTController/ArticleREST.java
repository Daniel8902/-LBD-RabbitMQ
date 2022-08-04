package com.RabbitMQ.SpringBootPublisher.RESTController;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleREST {

    @Autowired
    private RabbitTemplate template;
    @PostMapping("/article")
    public String createArticle(){
        template.convertAndSend("article-exchange","queue.article","Article Created");
        return "Message Send to RabbitMq Topic exchange";
    }

    @PutMapping("/article")
    public String updateArticle(@RequestParam("exchangeName") String exchange, @RequestParam("routingKey") String routingKey){
        template.convertAndSend(exchange, routingKey, "Article Updated");
        return "Message Send to RabbitMq Topic exchange";
    }
}
