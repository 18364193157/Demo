package com.test.MQ.rabbitMQ.springbootRabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @Description：
 * @Author: lenho
 * @Date：2018/9/13 16:57
 */
@Slf4j
@Component
public class MsgProducer implements RabbitTemplate.ConfirmCallback{

    private RabbitTemplate rabbitTemplate;

    @Autowired
    public MsgProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        //rabbitTemplate如果为单例的话，那回调就是最后设置的内容
        rabbitTemplate.setConfirmCallback(this);
    }

    /**
     * 延迟消费。比如： 用户生成订单之后，需要过一段时间校验订单的支付状态，如果订单仍未支付则需要及时地关闭订单。
     * @param content
     * @param expiration
     */
    public void sendMsg(String content,String expiration) {
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        //把消息放入ROUTINGKEY_A对应的队列当中去，对应的是队列A
        rabbitTemplate.convertAndSend(RabbitConfigure.EXCHANGE_A,RabbitConfigure.ROUTINGKEY_A,content,message -> {
            MessageProperties properties = message.getMessageProperties();
            properties.setExpiration(expiration);
            properties.setCorrelationId(correlationId.getId()); //生产者指定
            return message;
        });
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        log.info(" 回调id:" + correlationData);
        if (ack) {
            log.info("消息成功消费");
        } else {
            log.info("消息消费失败:" + cause);
        }

    }
}
