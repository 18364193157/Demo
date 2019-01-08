package com.test.MQ.activeMQ;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import javax.jms.Connection;
import java.sql.*;


/**
 * @Description：
 * @Author: lenho
 * @Date：2018/7/11 17:44
 */
public class Producer {
    public static void main(String[] args) throws JMSException {
        //创建连接（连接某个broker）
        ConnectionFactory connectionFactory=
                new ActiveMQConnectionFactory
                        ("tcp://192.168.232.128:61616");
        Connection connection=null;
        try {

            connection=connectionFactory.createConnection();
            connection.start();
            //创建会话
            Session session=connection.createSession
                    (Boolean.TRUE,Session.AUTO_ACKNOWLEDGE);
            //创建目的地（队列）
            Destination destination=session.createQueue("MyQueue");
            //创建发送者
            MessageProducer producer=session.createProducer(destination);
            //消息持久化
            producer.setDeliveryMode(DeliveryMode.PERSISTENT);
            //创建消息
            TextMessage message = session.createTextMessage("Hello World:");
            //发送消息
            producer.send(message);
            //提交会话（是相对于生产者来说的，确认消息可以在broker的provider上，消息可以被发送）
            session.commit();
            //关闭会话
            session.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}
