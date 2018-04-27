package com.test.order.utils;

import com.test.order.vo.ResultVO;

/**
 * @author chudichen
 * @date 2018/4/16
 */
public class ResultVOUtil {

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(object);
        return resultVO;
    }
}
