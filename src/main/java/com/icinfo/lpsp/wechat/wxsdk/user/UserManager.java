package com.icinfo.lpsp.wechat.wxsdk.user;

import com.icinfo.lpsp.wechat.wxsdk.token.TokenManager;
import com.icinfo.lpsp.wechat.wxsdk.user.bean.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 用户管理器
 */
public class UserManager {


    private static Logger logger = LoggerFactory.getLogger(UserManager.class);

    /**
     * 获取用户列表
     *
     * @param appID       微信appId
     * @param appsecret   微信appsecret
     * @param next_openid 第一个拉取的OPENID，不填默认从头开始拉取
     * @throws Exception
     */
    public static Users getUserList(String appID, String appsecret, String next_openid) throws Exception {
        Users users = UserAPI.getUserList(TokenManager.getToken(appID, appsecret).getAccess_token(), next_openid);
        return users;
    }
}
