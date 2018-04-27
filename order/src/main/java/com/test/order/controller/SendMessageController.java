package com.test.order.controller;

import com.test.order.message.SendChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author chudichen
 * @date 2018/4/25
 */
@Slf4j
@RestController
public class SendMessageController {

    @Autowired
    @Qualifier("output")
    private MessageChannel output;

    @GetMapping("sendMessage")
    public void sendChannel() {
        String sendMessage = "Now " + new Date();
        output.send(MessageBuilder.withPayload(sendMessage).build());
        log.info("Send message.");
    }
}
