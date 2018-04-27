package com.test.order.exception;

import com.test.order.enums.ResultEnum;

/**
 * @author chudichen
 * @date 2018/4/16
 */
public class OrderException extends RuntimeException {

    private Integer code;

    public OrderException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public OrderException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
