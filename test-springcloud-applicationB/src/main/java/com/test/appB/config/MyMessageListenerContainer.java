package com.test.appB.config;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * MQ消息监听容器
 */
@Component
public class MyMessageListenerContainer extends SimpleMessageListenerContainer {
    @Autowired
    private ConnectionFactory connectionFactory;

    public MyMessageListenerContainer(ConnectionFactory connectionFactory) {
        super(connectionFactory);
    }

    @Bean("rabbitListenerContainer")
    public SimpleRabbitListenerContainerFactory SimpleRabbitListenerContainerFactory() {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);

        factory.setMaxConcurrentConsumers(100);
        factory.setConcurrentConsumers(20);
        factory.setPrefetchCount(10);
        // 设置确认模式手工确认
        factory.setAcknowledgeMode(AcknowledgeMode.MANUAL);

        return factory;
    }

    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange(value = "ggg",
                    durable = "true", type = ExchangeTypes.DIRECT),
            key = "gggzzzrrr",
            value = @Queue(value = "gzrqueue",
                    autoDelete = "false", durable = "true", ignoreDeclarationExceptions = "true"
            )
    ), containerFactory = "rabbitListenerContainer")
    public void receiveMessageSmall(Message message, Channel channel) {
        System.out.println("来了" + message.toString());
    }
}
