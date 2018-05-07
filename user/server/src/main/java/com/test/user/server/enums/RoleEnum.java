package com.test.user.server.enums;

import lombok.Getter;

/**
 * @author chudichen
 * @date 2018/5/2
 */
@Getter
public enum RoleEnum {
    BUYER(1, "buyer"),
    SELLER(2, "seller");

    private Integer code;

    private String role;

    RoleEnum(Integer code, String role) {
        this.code = code;
        this.role = role;
    }
}
