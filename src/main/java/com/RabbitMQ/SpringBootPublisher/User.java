package com.RabbitMQ.SpringBootPublisher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    private String messageId;
    private String message;
    private Date messageDate;
    private String email;
    private String comment;
}
