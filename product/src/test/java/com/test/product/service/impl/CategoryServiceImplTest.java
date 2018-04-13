package com.test.product.service.impl;

import com.test.product.ProductApplicationTests;
import com.test.product.dataobject.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

/**
 * @author chudichen
 * @date 2018/4/13
 */
@Slf4j
public class CategoryServiceImplTest extends ProductApplicationTests{

    @Autowired
    private CategoryServiceImpl categoryServiceImpl;

    @Test
    public void findByCategoryTypeIn() throws Exception {
        List<ProductCategory> list =  categoryServiceImpl.findByCategoryTypeIn(Arrays.asList(11, 22));
        Assert.assertTrue(list.size() > 0);
        log.info(list.toString());
    }
}