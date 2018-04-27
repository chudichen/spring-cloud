package com.test.order.message;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.order.databoject.ProductInfo;
import com.test.order.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author chudichen
 * @date 2018/4/27
 */
@Slf4j
@Component
public class ProductInfoReceiver {

    private static final String PRODUCT_STOCK_TEMPLATE = "product_stock_%s";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RabbitListener(queuesToDeclare = @Queue("productInfo"))
    public void process(String message) {
        // Converts message => ProductInfo
        ObjectMapper objectMapper = JsonUtil.getObjectMapper();
        try {
            ProductInfo productInfo = objectMapper.readValue(message, ProductInfo.class);
            log.info("Receive message from queue productInfo : {}", productInfo);
            // Restores into redis.
            stringRedisTemplate.opsForValue().set(
                    // Redis key.
                    String.format(PRODUCT_STOCK_TEMPLATE, productInfo.getProductId()),
                    // Redis value.
                    String.valueOf(productInfo.getProductStock()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
