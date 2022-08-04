package com.RabbitMQ.SpringBootPublisher;

import com.RabbitMQ.SpringBootPublisher.Config.ArticleConfig;
import com.RabbitMQ.SpringBootPublisher.Config.Comment;
import com.RabbitMQ.SpringBootPublisher.Config.MQconfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Lisener {
    @RabbitListener(queues= Comment.QUEUE )
    public void listener(User user){
        System.out.println(user);
    }
    @RabbitListener(queues= MQconfig.QUEUE )
    public void listener2(User user){
        System.out.println(user);
    }
    @RabbitListener(queues= ArticleConfig.QUEUE )
    public void listenerArticle(Object object){
        System.out.println(object);
    }
}
