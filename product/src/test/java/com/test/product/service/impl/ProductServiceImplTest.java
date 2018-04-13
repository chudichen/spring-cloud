package com.test.product.service.impl;

import com.test.product.ProductApplicationTests;
import com.test.product.dataobject.ProductInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author chudichen
 * @date 2018/4/13
 */
@Slf4j
public class ProductServiceImplTest extends ProductApplicationTests {

    @Autowired
    private ProductServiceImpl ProductServiceImpl;

    @Test
    public void findOnShelfProduct() throws Exception {
        List<ProductInfo> list = ProductServiceImpl.findOnShelfProduct();
        Assert.assertTrue(list.size() > 0);
        log.info(list.toString());
    }

    @Test
    public void findOffShelfProduct() throws Exception {
        List<ProductInfo> list = ProductServiceImpl.findOffShelfProduct();
        Assert.assertTrue(list.size() > 0);
        log.info(list.toString());
    }

}