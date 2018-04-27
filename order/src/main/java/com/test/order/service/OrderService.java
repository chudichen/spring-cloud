package com.test.order.service;

import com.test.order.dto.OrderDTO;

/**
 * @author chudichen
 * @date 2018/4/15
 */
public interface OrderService {

    /**
     * Creates order.
     *
     * @param orderDTO OrderDTO
     * @return OrderDTO
     */
    OrderDTO create(OrderDTO orderDTO);
}
