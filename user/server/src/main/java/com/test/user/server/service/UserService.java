package com.test.user.server.service;

import com.test.user.server.dataobject.UserInfo;

/**
 * @author chudichen
 * @date 2018/5/2
 */
public interface UserService {

    /**
     * Query by openid.
     *
     * @param openid user openid.
     * @return UserInfo
     */
    UserInfo findByOpenid(String openid);
}
