package com.test.order.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * Receiver channel.
 *
 * @author chudichen
 * @date 2018/4/26
 */
public interface ReceiverChannel {

    String INPUT = "input";

    @Input(ReceiverChannel.INPUT)
    SubscribableChannel scoreInput();
}
