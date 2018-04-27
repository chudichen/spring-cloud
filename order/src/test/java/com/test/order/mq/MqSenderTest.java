package com.test.order.mq;

import com.test.order.OrderApplicationTests;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Send mq message.
 *
 * @author chudichen
 * @date 2018/4/23
 */
@Slf4j
public class MqSenderTest extends OrderApplicationTests {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void send() {
        amqpTemplate.convertAndSend("myQueue", "now " + new Date());
    }

    @Test
    public void sendOrder() {
        amqpTemplate.convertAndSend("digitalOrder", "digital " + new Date());
    }
}
