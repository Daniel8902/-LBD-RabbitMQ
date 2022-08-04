package com.RabbitMQ.SpringBootPublisher.RESTController;

import com.RabbitMQ.SpringBootPublisher.Config.MQconfig;
import com.RabbitMQ.SpringBootPublisher.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

@RestController
public class UserController {

    @Autowired
    private RabbitTemplate template;

//    @PostMapping("/publish")
//    public String publishMessage(@RequestBody User user) {
//        user.setMessageId(UUID.randomUUID().toString());
//        user.setMessageDate(new Date());
//        template.convertAndSend(MQconfig.EXCHANGE,
//                MQconfig.ROUTING_KEY, user);
//
//        return "Message Published";
//    }
    @PostMapping("/test")
    public String user(@RequestBody User user) {

        template.convertAndSend(MQconfig.EXCHANGE,
                MQconfig.ROUTING_KEY, user);

        return "Message Publishedtest";
    }
    @PutMapping("/email")
    public String email(@RequestBody User user) {

        template.convertAndSend(MQconfig.EXCHANGE,
                MQconfig.ROUTING_KEY, user);

        return "email Published";
    }
}
