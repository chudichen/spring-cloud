package com.test.order.message;

import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * Send channel config.
 *
 * @author chudichen
 * @date 2018/4/26
 */
@EnableBinding(SendChannel.class)
public class SendServerConfig {
}
