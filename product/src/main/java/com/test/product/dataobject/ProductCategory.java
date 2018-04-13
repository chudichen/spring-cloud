package com.test.product.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Mapping to table product_category.
 *
 * @author chudichen
 * @date 2018/4/13
 */
@Data
@Entity
public class ProductCategory {

    @Id
    @GeneratedValue
    private Integer categoryId;

    /** Category name */
    private String categoryName;

    /** Category type number */
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;
}