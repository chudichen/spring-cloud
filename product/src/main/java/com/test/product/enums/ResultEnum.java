package com.test.product.enums;

import lombok.Getter;

/**
 * @author chudichen
 * @date 2018/4/16
 */
@Getter
public enum  ResultEnum {

    /** Product not exist.  */
    PRODUCT_NOT_EXIST(1, "Product not exist."),

    /** Product stock error. */
    PRODUCT_STOCK_ERROR(2, "Product stock error.");

    ResultEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    private Integer code;

    private String message;
}
