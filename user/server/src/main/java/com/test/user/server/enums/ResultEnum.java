package com.test.user.server.enums;

import lombok.Getter;

/**
 * @author chudichen
 * @date 2018/4/16
 */
@Getter
public enum ResultEnum {

    /** Login error */
    LOGIN_FAIL(1, "Login error"),
    /** Role empty */
    ROLE_ERROR(2, "Role empty");

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
