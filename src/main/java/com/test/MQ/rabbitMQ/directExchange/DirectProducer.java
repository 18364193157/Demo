package com.test.MQ.rabbitMQ.directExchange;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
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
            String message = "First Direct Message";

            //为这个队列设置属性
//            Map<String,Object> argss = new HashMap<>();
//            argss.put("x-message-ttl",10000);//超时属性
//            argss.put("x-max-length",4);// 设定队列长度 当超出指定长度的时候，先入的消息会被发送到DLE（Dead Letter Exchange）中，成为“死信”，这个代表的是消息
//            堆积的时候，就是消费者一边消费的，一边有消息放入，例如：设置为4，当有10条进入的时候，会去掉先进入的6条消息，这是不公平的
            //创建direct类型的exchange（direct”,“fanout”,“topic”,“headers”）
//            channel.exchangeDeclare("directExchange","direct");
//            channel.queueDeclare("directQueue",false,false,false,null);
            //生产者和消费者都要声明一个队列，并将队列绑定到对应的Exchange上
//            channel.queueBind("directQueue","directExchange","directMessage");
            //如果要发送持久化消息，需以下配置,(对每条消息设置属性)
//            AMQP.BasicProperties props =
//                    new AMQP.BasicProperties("text/plain",
//                            "UTF-8",
//                            null,
//                            2,
//                            0, null, null, "2000",
//                            null, null, null, null,
//                            null, null);

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
