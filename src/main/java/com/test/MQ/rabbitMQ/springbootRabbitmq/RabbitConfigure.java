package com.test.MQ.rabbitMQ.springbootRabbitmq;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @Description：
 * @Author: lenho
 * @Date：2018/9/13 16:38
 */
@Data
@Slf4j
@Configuration
public class RabbitConfigure {

    @Value("${spring.rabbitmq.host}")
    private String host;

    @Value("${spring.rabbitmq.port}")
    private int port;

    @Value("${spring.rabbitmq.username}")
    private String username;

    @Value("${spring.rabbitmq.password}")
    private String password;

    @Value("${spring.rabbitmq.virtual-host}")
    private String virtualHost;


    public static final String EXCHANGE_A = "my-mq-exchange_A";
    public static final String EXCHANGE_B = "my-mq-exchange_B";
    public static final String EXCHANGE_C = "my-mq-exchange_C";

    public static final String FANOUT_EXCHANGE = "fanout_exchange";

    public static final String DELAY_EXCHANGE_NAME = "delay_exchange_name";
    public static final String QUEUE_EXPIRATION = "queue_expiration";


    public static final String QUEUE_A = "QUEUE_A";
    public static final String QUEUE_B = "QUEUE_B";
    public static final String QUEUE_C = "QUEUE_C";

    public static final String DELAY_QUEUE_PER_MESSAGE_TTL = "delay_queue_per_message_ttl";
    public static final String DELAY_QUEUE_PER_QUEUE_TTL = "delay_queue_per_queue_ttl";
    public static final String DELAY_PROCESS_QUEUE = "delay_process_queue";

    public static final String ROUTINGKEY_A = "spring-boot-routingKey_A";
    public static final String ROUTINGKEY_B = "spring-boot-routingKey_B";
    public static final String ROUTINGKEY_C = "spring-boot-routingKey_C";

    public static final String DELAY_PROCESS_QUEUE_NAME = "x-dead-letter-routing-key";

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory factory = new CachingConnectionFactory(host,port);
        factory.setUsername(username);
        factory.setPassword(password);
        factory.setVirtualHost(virtualHost);
        factory.setPublisherConfirms(true);
        return factory;
    }

    /**
     * 必须是prototype类型(一个RabbitTemplate只能支持一个ConfirmCallback)
     * @return
     */
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        rabbitTemplate.setConfirmCallback(new ConfirmCallBackListener());
        rabbitTemplate.setReturnCallback(new ReturnCallBackListener());
        rabbitTemplate.setMandatory(true);//如果发送方设置了mandatory模式,则会先调用basic.return方法.
        return rabbitTemplate;
    }

    /**
     * 针对消费者配置
     * 1. 设置交换机类型
     * 2. 将队列绑定到交换机
     FanoutExchange: 将消息分发到所有的绑定队列，无routingkey的概念
     HeadersExchange ：通过添加属性key-value匹配
     DirectExchange:按照routingkey分发到指定队列
     TopicExchange:多关键字匹配
     */
    @Bean
    public DirectExchange defaultExchange() {
        return new DirectExchange(EXCHANGE_A);
    }

    /**
     * 配置fanout_exchange
     * 广播模式   routing_key,设置了也无效
     * @return
     */
    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange(RabbitConfigure.FANOUT_EXCHANGE);
    }

    @Bean
    public DirectExchange delayExchange() {
        return new DirectExchange(DELAY_EXCHANGE_NAME);
    }

    /**
     * TTL配置在消息上的缓冲队列。
     * @return
     */
    @Bean
    public Queue delayQueueMessage(){
        return QueueBuilder.durable(DELAY_QUEUE_PER_MESSAGE_TTL)
                .withArgument("x-dead-letter-exchange",DELAY_EXCHANGE_NAME)// DLX，dead letter发送到的exchange
                .withArgument("x-dead-letter-routing-key",DELAY_PROCESS_QUEUE_NAME)// dead letter携带的routing key
                .build();
    }

    /**
     * TTL配置在队列上的缓冲队列。
     * @return
     */
    @Bean
    public Queue delayQueue(){
        return QueueBuilder.durable(DELAY_QUEUE_PER_QUEUE_TTL)
                .withArgument("x-dead-letter-exchange",DELAY_EXCHANGE_NAME)// DLX，dead letter发送到的exchange
                .withArgument("x-dead-letter-routing-key",DELAY_PROCESS_QUEUE_NAME)// dead letter携带的routing key
                .withArgument("x-message-ttl",QUEUE_EXPIRATION)// 设置队列的过期时间
                .build();
    }

    @Bean
    public Binding dlxBinding(){
        return BindingBuilder.bind(delayQueueMessage())
                .to(delayExchange())
                .with(DELAY_PROCESS_QUEUE_NAME);
    }


    /**
     * 获取队列A
     * 队列持久
     *
     * withArgument("x-ha-policy","all") :声明镜像队列替代普通的队列，rabbitMQ就会将该队列镜像到所有节点上；
     * withArgument("x-ha-policy","nodes*").withArgument("x-ha-policy-params","节点的名字"):
     * @return
     */
    @Bean
    public Queue queueA() {
        return QueueBuilder.durable(QUEUE_A).withArgument("x-ha-policy","all").build();
    }

    /**
     * 获取队列B
     * 队列持久
     * @return
     */
    @Bean
    public Queue queueB() {
        return new Queue(QUEUE_A, true,false,false,null);
    }

    @Bean
    public Binding binding(){
        return BindingBuilder
                .bind(queueA())
                .to(defaultExchange())
                .with(RabbitConfigure.ROUTINGKEY_A);
    }
    @Bean
    public Binding bindingB(){
        return BindingBuilder
                .bind(queueB())
                .to(defaultExchange())
                .with(RabbitConfigure.ROUTINGKEY_B);
    }

    @Bean
    public SimpleMessageListenerContainer messageContainer() {
        //加载处理消息A的队列
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory());
        //设置接收多个队列里面的消息，这里设置接收队列A
        //假如想一个消费者处理多个队列里面的信息可以如下设置：
        //container.setQueues(queueA(),queueB(),queueC());
        container.setQueues(queueA());
        container.setExposeListenerChannel(true);
        //设置最大的并发的消费者数量
        container.setMaxConcurrentConsumers(10);
        //最小的并发消费者的数量
        container.setConcurrentConsumers(1);
        //设置确认模式手工确认
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        container.setMessageListener(new ChannelAwareMessageListener() {
            @Override
            public void onMessage(Message message, Channel channel) throws Exception {
                /**通过basic.qos方法设置prefetch_count=1，这样RabbitMQ就会使得每个Consumer在同一个时间点最多处理一个Message，
                 换句话说,在接收到该Consumer的ack前,它不会将新的Message分发给它 */
                channel.basicQos(1);
                byte[] body = message.getBody();
                log.info("接收处理队列A当中的消息:" + new String(body));
                /**为了保证永远不会丢失消息，RabbitMQ支持消息应答机制。
                 当消费者接收到消息并完成任务后会往RabbitMQ服务器发送一条确认的命令，然后RabbitMQ才会将消息删除。*/
                channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            }
        });
        return container;
    }


}
