package com.test.MQ.rabbitMQ.directExchange;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Description：
 * @Author: lenho
 * @Date：2018/9/13 11:23
 */
public class DirectConsumers {
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = null;
        Channel channel = null;
        try {
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
                    this.getChannel().basicAck(envelope.getDeliveryTag(),false);
                }
            };
            while (true) {
                channel.basicConsume("directQueue", false, consumer);
            }
        }catch (Exception e){
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
