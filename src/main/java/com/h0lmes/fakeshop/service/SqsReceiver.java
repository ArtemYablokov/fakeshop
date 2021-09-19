package com.h0lmes.fakeshop.service;

import com.h0lmes.fakeshop.model.ShoppingCart;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Service;

@Service
public class SqsReceiver {


  @SqsListener("elasticache-sqs")
  public void userCacheListener(ShoppingCart shoppingCart) {
    String s = shoppingCart.getName();
    System.out.println(shoppingCart);
    System.out.println("Received Message for user..." + shoppingCart.getName());

  }
}
