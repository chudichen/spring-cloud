package com.test.product.service.impl;

import com.test.product.dataobject.ProductInfo;
import com.test.product.dto.CartDTO;
import com.test.product.enums.ProductStatusEnum;
import com.test.product.enums.ResultEnum;
import com.test.product.exception.ProductException;
import com.test.product.repository.ProductInfoRepository;
import com.test.product.service.ProductService;
import com.test.product.utils.JsonUtil;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chudichen
 * @date 2018/4/13
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public List<ProductInfo> findOnShelfProduct() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.ON.getCode());
    }

    @Override
    public List<ProductInfo> findOffShelfProduct() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.OFF.getCode());
    }

    @Override
    public List<ProductInfo> findList(List<String> productIdList) {
        return productInfoRepository.findByProductIdIn(productIdList);
    }

    @Override
    public void decreaseStock(List<CartDTO> cartDTOList) {
        List<ProductInfo> productInfoList = decreaseStockProcess(cartDTOList);
        productInfoList.forEach( productInfo -> {
            amqpTemplate.convertAndSend("productInfo", JsonUtil.toJson(productInfo));
        });
    }

    @Transactional(rollbackFor = Exception.class)
    public List<ProductInfo> decreaseStockProcess(List<CartDTO> cartDTOList) {
        List<ProductInfo> productInfoList = new ArrayList<>();
        cartDTOList.forEach(cartDTO -> {
            ProductInfo productInfo = productInfoRepository.findById(cartDTO.getProductId()).orElse(null);
            // Whether product is exist.
            if (productInfo == null) {
                throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer stock = productInfo.getProductStock() - cartDTO.getProductQuantity();
            // Whether stock is normal.
            if (stock < 0) {
                throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(stock);
            productInfoRepository.save(productInfo);
            productInfoList.add(productInfo);
        });
        return productInfoList;
    }
}
