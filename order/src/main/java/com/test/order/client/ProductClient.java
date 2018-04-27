package com.test.order.client;

import com.test.order.databoject.ProductInfo;
import com.test.order.dto.CartDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author chudichen
 * @date 2018/4/16
 */
@FeignClient(name = "product")
public interface ProductClient {

    /**
     * Get message.
     *
     * @return Product message.
     */
    @GetMapping("/msg")
    String productMsg();

    /**
     * Gets product list
     *
     * @param productIdList Product id list
     * @return product info list
     */
    @PostMapping("/product/listForOrder")
    List<ProductInfo> listForOrder(List<String> productIdList);

    /**
     * Uses the product service interface to decrease stock.
     *
     * @param cartDTOList cartDto list.
     */
    @PostMapping("/product/decreaseStock")
    void decreaseStock(@RequestBody List<CartDTO> cartDTOList);
}
