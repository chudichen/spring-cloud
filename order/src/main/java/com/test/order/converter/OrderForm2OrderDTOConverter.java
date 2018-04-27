package com.test.order.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.test.order.databoject.OrderDetail;
import com.test.order.dto.OrderDTO;
import com.test.order.enums.ResultEnum;
import com.test.order.exception.OrderException;
import com.test.order.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author chudichen
 * @date 2018/4/16
 */
@Slf4j
public class OrderForm2OrderDTOConverter {

    public static OrderDTO convert(OrderForm orderForm) {
        Gson gson = new Gson();
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());
        List<OrderDetail> orderDetailList;
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>() {
                    }.getType());
        } catch (Exception e) {
            log.error("[Json convert]error, string={}", orderForm.getItems());
            throw new OrderException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }
}
