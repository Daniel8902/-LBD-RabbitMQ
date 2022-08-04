package com.RabbitMQ.SpringBootPublisher.RESTController;

import com.RabbitMQ.SpringBootPublisher.Config.Comment;
import com.RabbitMQ.SpringBootPublisher.Config.MQconfig;
import com.RabbitMQ.SpringBootPublisher.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController {
    @Autowired
    private RabbitTemplate template;

    @PostMapping("/comment")
    public String comment(@RequestBody User user) {

        template.convertAndSend(Comment.EXCHANGE,
                Comment.ROUTING_KEY, user);

        return "Comment Published";
    }
    @PutMapping("/comment")
    public String commentUpdate(@RequestBody User user) {

        template.convertAndSend(Comment.EXCHANGE,
                Comment.ROUTING_KEY, user);

        return "Comment update";
    }
    @DeleteMapping("/deleteComment")
    public String Deletecoment(@RequestBody User user) {

        template.convertAndSend(Comment.EXCHANGE,
                Comment.ROUTING_KEY, user);

        return "Comment deleted";
    }
}
