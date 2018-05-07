package com.test.user.server.viewobject;

import lombok.Data;

/**
 * @author chudichen
 * @date 2018/4/16
 */
@Data
public class ResultVO<T> {

    private Integer code;

    private String msg;

    private T data;
}
