package com.test.order.databoject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Mapping to table product_info.
 *
 * @author chudichen
 * @date 2018/4/13
 */
@Data
@Entity
public class ProductInfo {

    @Id
    private String productId;

    /** Product name */
    private String productName;

    /** Product price */
    private BigDecimal productPrice;

    private Integer productStock;

    private String productDescription;

    private String productIcon;

    /** Product status,0:normal 1:off shelf */
    private Integer productStatus;

    private Integer categoryType;

    private Date createTime;

    private Date updateTime;
}
