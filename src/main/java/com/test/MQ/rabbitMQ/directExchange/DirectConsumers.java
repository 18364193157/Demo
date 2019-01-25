package com.test.MQ.rabbitMQ.directExchange;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * @Description：消费者
 * @Author: lenho
 * @Date：2018/9/13 11:23
 */
public class DirectConsumers {
    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setPort(5672);
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setVirtualHost("/");
        //创建与RabbitMQ服务器的TCP连接
        Connection connection = factory.newConnection();
        //创建信道Channel
        Channel channel = connection.createChannel();

        //创建direct类型的exchange（direct”,“fanout”,“topic”,“headers”）
        channel.exchangeDeclare("directExchange","direct");
        channel.queueDeclare("directQueue",false,false,false,null);
        //生产者和消费者都要声明一个队列，并将队列绑定到对应的Exchange上
        channel.queueBind("directQueue","directExchange","directMessage");

        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag,
                                       Envelope envelope,
                                       AMQP.BasicProperties properties,
                                       byte[] body)
                    throws IOException
            {
               String message = new String(body,"UTF-8");
                System.out.println(" Consumer have received '" + message + "'");
                System.out.println(" RoutingKey = " + envelope.getRoutingKey());
//                this.getChannel().basicAck(envelope.getDeliveryTag(),false);
            }
        };
        channel.basicConsume("directQueue", true, consumer);
    }
}
