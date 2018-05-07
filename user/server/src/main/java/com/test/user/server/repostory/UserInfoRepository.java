package com.test.user.server.repostory;

import com.test.user.server.dataobject.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author chudichen
 * @date 2018/5/2
 */
public interface UserInfoRepository extends JpaRepository<UserInfo, String> {

    /**
     * Query by openid.
     *
     * @param openid user openid.
     * @return UserInfo
     */
    UserInfo findByOpenid(String openid);
}
