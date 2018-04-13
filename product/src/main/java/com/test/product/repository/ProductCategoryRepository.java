package com.test.product.repository;

import com.test.product.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author chudichen
 * @date 2018/4/13
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    /**
     * Find Product category by categoryTypeList.
     *
     * @param categoryTypeList categoryTypeList
     * @return ProductCategory list
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
