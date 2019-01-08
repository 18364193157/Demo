package com.test.MQ.rabbitMQ.defaultExchange;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Description：
 * @Author: lenho
 * @Date：2018/9/13 11:23
 */
public class Consumers {
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = null;
        Channel channel = null;
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            factory.setPort(5672);
            factory.setUsername("rabbitmq_consumer");
            factory.setPassword("rabbitmq_consumer");
            factory.setVirtualHost("test_vhosts");
            //创建与RabbitMQ服务器的TCP连接
            connection = factory.newConnection();
            //创建信道Channel
            channel = connection.createChannel();
            Consumer consumer = new DefaultConsumer(channel){
                /*
                * 如果我们没有在basicConsume方法中指定Consumer Tag，RabbitMQ将使用随机生成的Consumer Tag
                * envelope是消息的打包信息:
                *       ._deliveryTag，消息发送的编号，表示这条消息是RabbitMQ发送的第几条消息
                *       ._redeliver，重传标志，确认在收到对消息的失败确认后，是否需要重发这条消息，false，不需要重发。
                *       _exchange，消息发送到的Exchange名称，正如我们上面发送消息时一样，exchange名称为空，使用的是Default Exchange。
                *       _routingKey,消息发送的路由Key，我们这里是发送消息时设置的“firstQueue”
                *
                * */
                @Override
                public void handleDelivery(String consumerTag,
                                           Envelope envelope,
                                           AMQP.BasicProperties properties,
                                           byte[] body)
                        throws IOException
                {
                   String message = new String(body,"UTF-8");
                    System.out.println(" Consumer have received '" + message + "'");
                    /*
                    multiple是消息确认方式，如果值为true,表示对消息队列里所有编号小于或等于当前消息编号的未确认消息进行手动确认，
                    如果为false，表示仅确认当前消息
                    */
                    this.getChannel().basicAck(envelope.getDeliveryTag(),false);
                }
            };
            /*
            * autoAck:true 表示Consumer接受到消息后，会自动发确认消息(Ack消息)给消息队列，消息队列会将这条消息从消息队列里删除
            * Consumer对象，用于处理接收到的消息
            * */
            channel.basicConsume("directQueue", false, consumer);
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
