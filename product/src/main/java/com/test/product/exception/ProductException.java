package com.test.product.exception;

import com.test.product.enums.ResultEnum;

/**
 * @author chudichen
 * @date 2018/4/16
 */
public class ProductException extends RuntimeException {

    private Integer code;

    public ProductException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public ProductException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
