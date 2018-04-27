package com.test.product.controller;

import com.test.product.dataobject.ProductCategory;
import com.test.product.dataobject.ProductInfo;
import com.test.product.dto.CartDTO;
import com.test.product.service.CategoryService;
import com.test.product.service.ProductService;
import com.test.product.utils.ResultVOUtil;
import com.test.product.viewobject.ProductInfoVO;
import com.test.product.viewobject.ProductVO;
import com.test.product.viewobject.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chudichen
 * @date 2018/4/13
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO<ProductVO> list() {
        List<ProductInfo> productInfoList = productService.findOnShelfProduct();
        List<Integer> categoryTypeList = productInfoList.stream().map(ProductInfo::getCategoryType).collect(Collectors.toList());
        List<ProductCategory> categoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
        List<ProductVO> productVOList = new ArrayList<>();
        categoryList.forEach(productCategory -> {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            productInfoList.forEach(productInfo -> {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            });
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        });
        return ResultVOUtil.success(productVOList);
    }

    /**
     * Gets product list.
     *
     * @param productIdList Id list.
     * @return Product info list
     */
    @PostMapping("/listForOrder")
    public List<ProductInfo> listForOrder(@RequestBody List<String> productIdList) {
        return productService.findList(productIdList);
    }

    @PostMapping("/decreaseStock")
    public void decreaseStock(@RequestBody List<CartDTO> cartDTOList) {
        productService.decreaseStock(cartDTOList);
    }
}
