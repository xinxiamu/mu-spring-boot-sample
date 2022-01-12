package com.neo.rabbit.hello;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RabbitListener(queues = "hello")
public class HelloReceiver {

    //1.启动多个应用实力，只有一个实例消费了消息。随机一个实例消费
    //RabbitMQ会将消息循环到消费者，但只有一个消费者会从队列中接收消息。这是在RabbitMQ中设计的，当你在一个队列上有多个消费者时。
    @RabbitHandler
    public void process(String hello) {
        System.out.println("---------Receiver  : " + hello);
    }

}
