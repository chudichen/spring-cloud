package com.test.order.controller;

import com.test.order.converter.OrderForm2OrderDTOConverter;
import com.test.order.dto.OrderDTO;
import com.test.order.enums.ResultEnum;
import com.test.order.exception.OrderException;
import com.test.order.form.OrderForm;
import com.test.order.service.OrderService;
import com.test.order.utils.ResultVOUtil;
import com.test.order.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chudichen
 * @date 2018/4/13
 */
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 1. Parameter check.
     * 2. Query product information(call product service).
     * 3. Calculate the total price.
     * 4. Deduction library(call product service).
     * 5. Order warehousing.
     */
    @PostMapping("/create")
    public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm,
                                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            log.error("[Create order] parameter error, orderForm={}", orderForm);
            throw new OrderException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        // orderForm -> orderDTO
        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("[Create order]cart information is empty.");
            throw new OrderException(ResultEnum.CART_EMPTY);
        }
        OrderDTO result = orderService.create(orderDTO);
        Map<String, String> map = new HashMap<>(1);
        map.put("orderId", result.getOrderId());
        return ResultVOUtil.success(map);
    }
}
