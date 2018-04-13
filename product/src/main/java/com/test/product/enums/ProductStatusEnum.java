package com.test.product.enums;

import lombok.Getter;

/**
 * Product sell status.
 *
 * @author chudichen
 * @date 2018/4/13
 */
@Getter
public enum ProductStatusEnum {

    /** On shelf */
    ON(0, "On shelf"),

    /** Off shelf */
    OFF(1, "Off shelf");

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
