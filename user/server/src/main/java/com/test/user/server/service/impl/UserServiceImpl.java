package com.test.user.server.service.impl;

import com.test.user.server.dataobject.UserInfo;
import com.test.user.server.repostory.UserInfoRepository;
import com.test.user.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chudichen
 * @date 2018/5/2
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserInfo findByOpenid(String openid) {
        return userInfoRepository.findByOpenid(openid);
    }
}
