package com.test.MQ.rabbitMQ.RpcExchange;

import com.rabbitmq.client.*;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.queue.QueueConsumer;
import org.apache.curator.framework.state.ConnectionState;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeoutException;

/**
 * @Description：
 * @Author: lenho
 * @Date：2018/9/13 10:21
 */
public class RPCProducer {
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = null;
        Channel channel = null;
        try{
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            factory.setPort(5672);
            factory.setUsername("rabbitmq_producer");
            factory.setPassword("rabbitmq_producer");
            factory.setVirtualHost("test_vhosts");
            //创建与RabbitMQ服务器的TCP连接
            connection = factory.newConnection();
            //创建信道Channel
            channel = connection.createChannel();
            //创建RPC发送消息的Direct Exchange,消息队列和绑定关系。
            channel.exchangeDeclare("rpcSendExchange","direct");
            channel.queueDeclare("rpcSendQueue",true,false,false,null);
            channel.queueBind("rpcSendQueue","rpcSendExchange","rpcSendMessage");

            //建立RPC返回消息的Direct Exchange, 消息队列和绑定关系
            channel.exchangeDeclare("rpcReplyExchange", "direct",true);
            channel.queueDeclare("rpcReplyQueue", true, false, false, null);
            channel.queueBind("rpcReplyQueue", "rpcReplyExchange", "rpcReplyMessage");

            //创建接收RPC返回消息的消费者，并将它与RPC返回消息队列相关联。
            Consumer replyCustomer = new DefaultConsumer(channel){
                @Override
                public void handleDelivery(String consumerTag,
                                           Envelope envelope,
                                           AMQP.BasicProperties properties,
                                           byte[] body)
                        throws IOException
                {
                    String correlationId = properties.getCorrelationId();
                    System.out.println(" CorrelationId = " + correlationId);
                    String message = new String(body,"UTF-8");
                    System.out.println(" Consumer have received '" + message + "'");
                    System.out.println(" RoutingKey = " + envelope.getRoutingKey());
                }
            };
            //生成RPC请求消息的CorrelationId
            String correlationId = UUID.randomUUID().toString();

            //在RabbitMQ消息的Properties中设置RPC请求消息的CorrelationId以及
            //ReplyTo名称(我们这里使用的是Exchange名称，
            //而不是消息队列名称)
            AMQP.BasicProperties props =
                    new AMQP.BasicProperties("text/plain",
                            "UTF-8",
                            null,
                            2,
                            0, correlationId, "rpcReplyExchange", null,
                            null, null, null, null,
                            null, null);
            System.out.println("The send message's correlation id is:" + correlationId);
            String number = "10";
            channel.basicPublish("rpcSendExchange", "rpcSendMessage", props, number.getBytes());
            System.out.println("Send Message is:'" + number + "'");


            while (true) {
                channel.basicConsume("rpcReplyQueue", true,replyCustomer);
            }


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
