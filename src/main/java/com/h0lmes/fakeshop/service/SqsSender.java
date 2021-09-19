package com.h0lmes.fakeshop.service;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.h0lmes.fakeshop.model.ShoppingCart;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class SqsSender {

    private final QueueMessagingTemplate queueMessagingTemplate;


    public SqsSender(AmazonSQSAsync amazonSQSAsync) {
        this.queueMessagingTemplate = new QueueMessagingTemplate(amazonSQSAsync);
    }

    public void send(ShoppingCart shoppingCart) {
        System.out.println("Sending user to SQS..." + shoppingCart.getName());
        queueMessagingTemplate.convertAndSend("elasticache-sqs", shoppingCart);
    }
}
