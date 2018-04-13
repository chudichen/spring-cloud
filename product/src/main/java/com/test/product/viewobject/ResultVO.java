package com.test.product.viewobject;

import lombok.Data;

/**
 * Response result.
 *
 * @author chudichen
 * @date 2018/4/13
 */
@Data
public class ResultVO<T> {

    /** Error code */
    private Integer code;

    /** Error message */
    private String msg;

    /** data */
    private T data;
}
