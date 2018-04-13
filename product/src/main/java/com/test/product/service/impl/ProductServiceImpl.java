package com.test.product.service.impl;

import com.test.product.dataobject.ProductInfo;
import com.test.product.enums.ProductStatusEnum;
import com.test.product.repository.ProductInfoRepository;
import com.test.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chudichen
 * @date 2018/4/13
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfo> findOnShelfProduct() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.ON.getCode());
    }

    @Override
    public List<ProductInfo> findOffShelfProduct() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.OFF.getCode());
    }
}
