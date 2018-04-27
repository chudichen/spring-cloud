package com.test.order.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author chudichen
 * @date 2018/4/26
 */
public interface SendChannel {

    String OUTPUT = "output";

    /**
     * Send message.
     *
     * @return send message.
     */
    @Output(SendChannel.OUTPUT)
    MessageChannel output();
}
