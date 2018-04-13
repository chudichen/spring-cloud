package com.test.product.viewobject;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Product view object.
 *
 * @author chudichen
 * @date 2018/4/13
 */
@Data
public class ProductVO {

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;
}
