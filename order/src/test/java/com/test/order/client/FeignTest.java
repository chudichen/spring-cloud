package com.test.order.client;

import com.test.order.OrderApplicationTests;
import com.test.order.client.ProductClient;
import com.test.order.databoject.ProductInfo;
import com.test.order.dto.CartDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

/**
 * @author chudichen
 * @date 2018/4/16
 */
@Slf4j
public class FeignTest extends OrderApplicationTests {

    @Autowired
    private ProductClient productClient;

    @Test
    public void testGetList() throws Exception {
        List<ProductInfo> list = productClient.listForOrder(Arrays.asList("157875196366160022", "157875227953464068"));
        log.info(list.toString());
    }

    @Test
    public void testDecreaseStock() throws Exception {
        productClient.decreaseStock(Arrays.asList(new CartDTO("157875227953464068", 1)));
    }
}