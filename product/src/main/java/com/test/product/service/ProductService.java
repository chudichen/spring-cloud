package com.test.product.service;

import com.test.product.dataobject.ProductInfo;
import com.test.product.dto.CartDTO;

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

    /**
     * Find product list.
     *
     * @param productIdList product id list.
     * @return product info list.
     */
    List<ProductInfo> findList(List<String> productIdList);

    /**
     * Decrease stock quantity.
     *
     * @param cartDTOList CartDTO list
     */
    void decreaseStock(List<CartDTO> cartDTOList);
}
