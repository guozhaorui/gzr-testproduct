package com.test.appA.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MqSender {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //由于rabbitTemplate的scope属性设置为ConfigurableBeanFactory.SCOPE_PROTOTYPE，所以不能自动注入
    private RabbitTemplate rabbitTemplate;

    /**
     * 构造方法注入rabbitTemplate
     */
    @Autowired
    public MqSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
            logger.info(" 回调id:" + correlationData);
            if (ack) {
                logger.info("消息成功消费");
            } else {
                logger.info("消息消费失败:" + cause);
            }
        }); //rabbitTemplate如果为单例的话，那回调就是最后设置的内容
    }

    /**
     * 发送消息
     *
     * @param exchange
     * @param routing
     * @param msg
     */
    public void send(String exchange, String routing, String msg) {
        rabbitTemplate.convertAndSend(exchange, routing, msg, new CorrelationData(UUID.randomUUID().toString()));
    }
}

