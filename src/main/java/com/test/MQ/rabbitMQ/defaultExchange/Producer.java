package com.test.MQ.rabbitMQ.defaultExchange;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * @Description：
 * @Author: lenho
 * @Date：2018/9/13 10:21
 */
public class Producer {
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
            /*
            第二个参数durable表示建立的消息队列是否是持久化(RabbitMQ重启后仍然存在,并不是指消息的持久化),
            第三个参数exclusive 表示建立的消息队列是否只适用于当前TCP连接，第四个参数autoDelete表示当队列不再被使用时，
            RabbitMQ是否可以自动删除这个队列。 第五个参数arguments定义了队列的一些参数信息，主要用于Headers Exchange进行消息匹配时。
            */
            //为这个队列设置属性
            Map<String,Object> argss = new HashMap<>();
            argss.put("x-message-ttl",6000);//超时属性
            channel.queueDeclare("firstQueue",true,false,false,null);
            String message = "First Message";
           /* BindingKey是Exchange和Queue绑定的规则描述，这个描述用来解析当Exchange接收到消息时，Exchange接收到的消息会带有RoutingKey这个字段
           *  props:消息包含的属性。RabbitMQ的消息属性和消息体是分开的
           *  body:消息体。
           *  调用basicPublish方法发送消息时，props参数为null，因而我们发送的消息是非持久化消息
           * */
//            如果要发送持久化消息，需以下配置,对每条消息设置属性
            AMQP.BasicProperties props =
                    new AMQP.BasicProperties("text/plain",
                            "UTF-8",
                            null,
                            2,
                            0, null, null, null,
                            null, null, null, null,
                            null, null);
            channel.basicPublish("","firstQueue",null,message.getBytes());
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
