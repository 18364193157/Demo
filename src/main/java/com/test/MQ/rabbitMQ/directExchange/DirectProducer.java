package com.test.MQ.rabbitMQ.directExchange;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Description： 生产者
 * @Author: lenho
 * @Date：2018/9/13 10:21
 */
public class DirectProducer {
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = null;
        Channel channel = null;
        try{
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            factory.setPort(5672);
            factory.setUsername("guest");
            factory.setPassword("guest");
            factory.setVirtualHost("/");
            //创建与RabbitMQ服务器的TCP连接
            connection = factory.newConnection();
            //创建信道Channel
            channel = connection.createChannel();
            //创建direct类型的exchange（direct”,“fanout”,“topic”,“headers”）
            channel.exchangeDeclare("directExchange","direct");
            channel.queueDeclare("directQueue",true,false,false,null);
            //生产者和消费者都要声明一个队列，并将队列绑定到对应的Exchange上
            channel.queueBind("directQueue","directExchange","directMessage");
            String message = "First Direct Message";
            channel.basicPublish("directExchange","directMessage",null,message.getBytes());
            System.out.println("Send Message is:'" + message + "'");
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(channel != null) {
                channel.close();
            }
            if(connection != null) {
                connection.close();
            }
        }
    }
}
