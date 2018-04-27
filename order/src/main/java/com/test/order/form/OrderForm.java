package com.test.order.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author chudichen
 * @date 2018/4/16
 */
@Data
public class OrderForm {

    /**
     * Buyer name
     */
    @NotEmpty(message = "Name must")
    private String name;

    /**
     * Buyer phone
     */
    @NotEmpty(message = "Phone must")
    private String phone;

    /**
     * Buyer address
     */
    @NotEmpty(message = "Address must")
    private String address;

    /**
     * Buyer weChat openid
     */
    @NotEmpty(message = "Openid must")
    private String openid;

    /**
     * Shopping cart
     */
    @NotEmpty(message = "Shopping cart can not be empty")
    private String items;
}
