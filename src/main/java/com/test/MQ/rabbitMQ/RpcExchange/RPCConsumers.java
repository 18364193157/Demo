package com.test.MQ.rabbitMQ.RpcExchange;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Description：
 * @Author: lenho
 * @Date：2018/9/13 11:23
 */
public class RPCConsumers {
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

                @Override
                public void handleDelivery(String consumerTag,
                                           Envelope envelope,
                                           AMQP.BasicProperties properties,
                                           byte[] body)
                        throws IOException
                {
                    //获取返回消息发送到的Exchange名称
                    String replyExchange = properties.getReplyTo();
                    //设置返回消息的Properties，附带发送消息的CorrelationId.
                    AMQP.BasicProperties replyProps = new AMQP.BasicProperties.Builder()
                            .correlationId(properties.getCorrelationId())
                            .build();
                    String message = new String(body,"UTF-8");
                    System.out.println("The received message is:" + message);
                    System.out.println("The received message's correlation id is:" + properties.getCorrelationId());
                    int number = Integer.parseInt(message);
                    String response = "10 received";
                    this.getChannel().basicPublish(replyExchange,"rpcReplyMessage",replyProps,response.getBytes());
                }
            };
            while (true) {
                channel.basicConsume("rpcSendQueue", true, consumer);
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
