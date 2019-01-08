package com.test.MQ.activeMQ.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;


/**
 * @Description：
 * @Author: lenho
 * @Date：2018/7/11 17:44
 */
public class ProducerTopic {
    public static void main(String[] args) throws JMSException {
        //创建连接
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
            Destination destination=session.createTopic("MyTopic");
            //创建发送者
            MessageProducer producer=session.createProducer(destination);
            //创建消息
            TextMessage message = session.createTextMessage("上班时间是周日");
            //发送消息
            producer.send(message);
            //提交会话（是相对于生产者来说的，确认消息可以在broker的provider上，消息可以被发送）
            session.commit();
            //关闭会话
            session.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }finally {
            if(connection!=null){
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
