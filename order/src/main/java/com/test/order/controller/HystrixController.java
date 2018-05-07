package com.test.order.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.test.order.databoject.ProductInfo;
import com.test.order.feign.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

/**
 * @author chudichen
 * @date 2018/5/3
 */
@RestController
public class HystrixController {

    @Autowired
    private ProductClient productClient;

    @GetMapping("/getProductInfoList")
    public List<ProductInfo> getProductInfoList(@RequestParam("number") Integer number) {
        List<ProductInfo> list = productClient.listForOrder(Collections.singletonList("157875196366160022"));
        return list;
    }

    private String fallback() {
        return "Too crowded please try again later.";
    }
}
