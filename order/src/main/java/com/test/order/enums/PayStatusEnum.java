package com.test.order.enums;

import lombok.Getter;

/**
 * @author chudichen
 * @date 2018/4/15
 */
@Getter
public enum PayStatusEnum {

    /** Wait for payment. */
    WAIT(0, "Wait for payment."),

    /** Pay success. */
    SUCCESS(1, "Pay success");

    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
