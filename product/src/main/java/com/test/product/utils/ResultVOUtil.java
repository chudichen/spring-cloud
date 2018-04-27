package com.test.product.utils;

import com.test.product.viewobject.ResultVO;

/**
 * Result util.
 *
 * @author chudichen
 * @date 2018/4/14
 */
public class ResultVOUtil {

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("success");
        return resultVO;
    }
}
