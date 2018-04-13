package com.test.product.service;

import com.test.product.dataobject.ProductInfo;

import java.util.List;

/**
 * Product service
 *
 * @author chudichen
 * @date 2018/4/13
 */
public interface ProductService {

    /**
     * Finds all on shelf products.
     *
     * @return List<ProductInfo>
     */
    List<ProductInfo> findOnShelfProduct();

    /**
     * Finds all off shelf products.
     *
     * @return List<ProductInfo>
     */
    List<ProductInfo> findOffShelfProduct();
}
