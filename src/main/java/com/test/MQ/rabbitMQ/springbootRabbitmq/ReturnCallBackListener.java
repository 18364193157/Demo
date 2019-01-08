package com.test.MQ.rabbitMQ.springbootRabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * @Description：消息失败回调
 *通过实现 ReturnCallback 接口，启动消息失败返回，比如路由不到队列时触发回调
 * @Author: lenho
 * @Date：2018/9/14 15:52
 */
@Component
@Slf4j
public class ReturnCallBackListener implements RabbitTemplate.ReturnCallback {

    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {

    }
}
