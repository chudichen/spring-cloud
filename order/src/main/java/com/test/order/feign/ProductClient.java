package com.test.order.feign;

import com.test.order.databoject.ProductInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author chudichen
 * @date 2018/5/3
 */
@FeignClient(name = "product", fallback = ProductClient.ProductClientFallback.class)
public interface ProductClient {

    /**
     * Gets product service method.
     *
     * @param productList product id list.
     * @return product info list.
     */
    @PostMapping("/product/listForOrder")
    List<ProductInfo> listForOrder(@RequestBody List<String> productList);

    @Component
    static class ProductClientFallback implements ProductClient {
        @Override
        public List<ProductInfo> listForOrder(List<String> productList) {
            return null;
        }
    }
}
