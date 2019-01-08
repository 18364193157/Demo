package com.test.MQ.rabbitMQ.springbootRabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description：一个生产者，多个消费者，可以写多个消费者，并且他们的分发是负载均衡的。
 * @Author: lenho
 * @Date：2018/9/13 17:51
 */
@Slf4j
@Component
@RabbitListener(queues = RabbitConfigure.DELAY_PROCESS_QUEUE)
public class MsgReceiver {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RabbitHandler
    public void process(String content) {
        if(content.equals("fail_messsage")) {
            CorrelationData correlationData = new CorrelationData();
            rabbitTemplate.convertAndSend(RabbitConfigure.DELAY_EXCHANGE_NAME,RabbitConfigure.DELAY_PROCESS_QUEUE_NAME,content,correlationData);
        }else {
            log.info("接收处理队列A当中的消息： " + content);
        }
    }
}
