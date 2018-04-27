package com.test.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chudichen
 * @date 2018/4/16
 */
@RestController
public class ServerController {

    @GetMapping
    public String msg() {
        return "";
    }
}
