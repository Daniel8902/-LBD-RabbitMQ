package com.RabbitMQ.SpringBootPublisher.RESTController;

import com.RabbitMQ.SpringBootPublisher.Config.MQconfig;
import com.RabbitMQ.SpringBootPublisher.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Article2Controller {
    @Autowired
    private RabbitTemplate template;


    @PostMapping("/articlee")
    public String createArticle2(){
        template.convertAndSend("article_exchange2","article_routingKey2","Article2 Created");
        return "Message Send to RabbitMq ";
    }
    @PutMapping("/article2")
    public String updateArticle2(){
        template.convertAndSend("article_exchange2","article_routingKey2","Article2 update");
        return "Message Send to RabbitMq ";
    }
}
