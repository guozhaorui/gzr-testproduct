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

import java.io.IOException;

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
        factory.setAcknowledgeMode(AcknowledgeMode.AUTO);

        return factory;
    }

    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange(value = "exchange_gzr1",
                    durable = "true", type = ExchangeTypes.DIRECT),
            key = "routingKey",
            value = @Queue(value = "gzrqueue",
                    autoDelete = "false", durable = "true", ignoreDeclarationExceptions = "true"
            )
    ), containerFactory = "rabbitListenerContainer")
    public void receiveMessageSmall(Message message, Channel channel) {
        System.out.println("来了" + message.toString());
    }


    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange(value = "exchange_gzr2",
                    durable = "true", type = ExchangeTypes.TOPIC),
            value = @Queue(value = "gzrqueue2",
                    autoDelete = "false", durable = "true", ignoreDeclarationExceptions = "true"
            )
    ), containerFactory = "rabbitListenerContainer")
    public void gzrqueue2(Message message, Channel channel) {
        System.out.println("我是topic模式gzrqueue2" + message.toString());
    }

    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange(value = "exchange_gzr2",
                    durable = "true", type = ExchangeTypes.TOPIC),
            value = @Queue(value = "gzrqueue3",
                    autoDelete = "false", durable = "true", ignoreDeclarationExceptions = "true"
            )
    ), containerFactory = "rabbitListenerContainer")
    public void gzrqueue3(Message message, Channel channel) throws IOException {
        System.out.println("我是topic模式gzrqueue3" + message.toString());
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),true);
    }
}
