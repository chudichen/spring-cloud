package com.test.order.enums;

import lombok.Getter;

/**
 * @author chudichen
 * @date 2018/4/15
 */
@Getter
public enum OrderStatusEnum {

    /** New order */
    NEW(0, "New Order"),

    /** Finished order */
    FINISHED(1, "Finished Order"),

    /** Cancel order */
    CANCEL(2, "Cancel Order");

    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
