package com.test.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 * @author chudichen
 * @date 2018/4/26
 */
@Slf4j
@EnableBinding({ReceiverChannel.class})
public class ReceiverServerConfig {

    @StreamListener(ReceiverChannel.INPUT)
    public void receive(Object object) {
        log.info("Receive message : {}",object);
    }
}