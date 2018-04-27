package com.test.order.service.impl;

import com.test.order.client.ProductClient;
import com.test.order.dao.OrderDetailRepository;
import com.test.order.dao.OrderMasterRepository;
import com.test.order.databoject.OrderDetail;
import com.test.order.databoject.OrderMaster;
import com.test.order.databoject.ProductInfo;
import com.test.order.dto.CartDTO;
import com.test.order.dto.OrderDTO;
import com.test.order.enums.OrderStatusEnum;
import com.test.order.enums.PayStatusEnum;
import com.test.order.service.OrderService;
import com.test.order.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chudichen
 * @date 2018/4/15
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private ProductClient productClient;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        // Uses product service to find product info.
        List<String> productIdList = orderDTO.getOrderDetailList().stream()
                .map(OrderDetail :: getDetailId)
                .collect(Collectors.toList());
        List<ProductInfo> productInfoList = productClient.listForOrder(productIdList);
        String orderId = KeyUtil.genUniqueKey();
        // Calculate the total price.
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);
        for (OrderDetail orderDetail : orderDTO.getOrderDetailList()) {
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getProductId().equals(orderDetail.getProductId())) {
                    // Unit price * quantity.
                    orderAmount = productInfo.getProductPrice()
                            .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                            .add(orderAmount);
                    BeanUtils.copyProperties(productIdList, orderDetail);
                    orderDetail.setOrderId(orderId);
                    orderDetail.setDetailId(KeyUtil.genUniqueKey());
                    // Saves order detail.
                    orderDetailRepository.save(orderDetail);
                }
            }
        }
        // Uses product service decrease stock.
        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList().stream()
                .map(orderDetail -> new CartDTO(orderDetail.getProductId(), orderDetail.getProductQuantity()))
                .collect(Collectors.toList());
        productClient.decreaseStock(cartDTOList);
        // Saves order.
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(orderId);
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterRepository.save(orderMaster);
        return orderDTO;
    }
}
