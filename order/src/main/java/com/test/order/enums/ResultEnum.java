package com.test.order.enums;

import lombok.Getter;

/**
 * @author chudichen
 * @date 2018/4/16
 */
@Getter
public enum  ResultEnum {

    /** Parameter error */
    PARAM_ERROR(1, "Parameter error"),
    /** Cart empty */
    CART_EMPTY(2, "Cart empty");

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
