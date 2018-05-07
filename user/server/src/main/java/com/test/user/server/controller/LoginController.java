package com.test.user.server.controller;

import com.test.user.server.constant.CookieConstant;
import com.test.user.server.constant.RedisConstant;
import com.test.user.server.dataobject.UserInfo;
import com.test.user.server.enums.ResultEnum;
import com.test.user.server.enums.RoleEnum;
import com.test.user.server.service.UserService;
import com.test.user.server.utils.CookieUtil;
import com.test.user.server.utils.ResultVOUtil;
import com.test.user.server.viewobject.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author chudichen
 * @date 2018/5/2
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/buyer")
    public ResultVO buyer(@RequestParam("openid") String openid,
                          HttpServletResponse response) {
        UserInfo userInfo = userService.findByOpenid(openid);
        // Whether the user exists.
        if (userInfo == null) {
            return ResultVOUtil.error(ResultEnum.LOGIN_FAIL);
        }
        // Determine if the role is correct.
        if (!RoleEnum.BUYER.getCode().equals(userInfo.getRole())) {
            return ResultVOUtil.error(ResultEnum.ROLE_ERROR);
        }
        // Set cookie.
        CookieUtil.set(response, CookieConstant.OPENID, openid, CookieConstant.expire);
        return ResultVOUtil.success();
    }

    @GetMapping("/seller")
    public ResultVO seller(@RequestParam("openid") String openid,
                          HttpServletResponse response) {
        UserInfo userInfo = userService.findByOpenid(openid);
        // Whether the user exists.
        if (userInfo == null) {
            return ResultVOUtil.error(ResultEnum.LOGIN_FAIL);
        }
        // Determine if the role is correct.
        if (RoleEnum.SELLER.getCode().equals(userInfo.getRole())) {
            return ResultVOUtil.error(ResultEnum.ROLE_ERROR);
        }
        String token = UUID.randomUUID().toString();
        Integer expire = CookieConstant.expire;
        stringRedisTemplate.opsForValue().set(
                String.format(RedisConstant.TOKEN_TEMPLATE, token), openid, expire, TimeUnit.SECONDS);
        // Set cookie.
        CookieUtil.set(response, CookieConstant.TOKEN, token, CookieConstant.expire);
        return ResultVOUtil.success();
    }
}
