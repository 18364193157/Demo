package com.test.MQ.activeMQ.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;


/**
 * @Description：
 * @Author: lenho
 * @Date：2018/7/11 17:44
 */
public class ConsumerTopic02 {
    public static void main(String[] args) throws JMSException {
        //创建连接
        ActiveMQConnectionFactory activeMQConnectionFactory =
                new ActiveMQConnectionFactory("tcp://192.168.232.128:61616");
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        //创建会话
        Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
        //创建目的地（队列）
        Destination destination = session.createTopic("MyTopic");
        //创建消费者
        MessageConsumer consumer = session.createConsumer(destination);
        //接受信息
//        TextMessage receive = (TextMessage) consumer.receive();
//        System.out.println(receive.getText());
//        session.commit();
//        session.close();
        //创建监听接受信息
        MessageListener listener = message -> {
            try {
                System.out.println(((TextMessage)message).getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        };
        while (true) {
            consumer.setMessageListener(listener);
            session.commit();
        }
    }
}
