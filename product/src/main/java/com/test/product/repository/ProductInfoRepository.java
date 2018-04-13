package com.test.product.repository;

import com.test.product.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author chudichen
 * @date 2018/4/13
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

    /**
     * Gets product list by product status.
     *
     * @param productStatus product status
     * @return product list
     */
    List<ProductInfo> findByProductStatus(Integer productStatus);
}
