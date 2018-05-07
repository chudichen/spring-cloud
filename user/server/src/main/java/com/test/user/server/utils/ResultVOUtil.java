package com.test.user.server.utils;


import com.test.user.server.enums.ResultEnum;
import com.test.user.server.viewobject.ResultVO;

/**
 * @author chudichen
 * @date 2018/4/16
 */
public class ResultVOUtil {

    public static ResultVO success() {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("Success");
        return resultVO;
    }

    public static ResultVO error(ResultEnum resultEnum) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(resultEnum.getCode());
        resultVO.setMsg(resultEnum.getMessage());
        return resultVO;
    }
}
