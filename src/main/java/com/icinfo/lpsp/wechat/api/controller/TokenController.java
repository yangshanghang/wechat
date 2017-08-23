package com.icinfo.lpsp.wechat.api.controller;

import com.icinfo.lpsp.wechat.common.constant.ConfigConstant;
import com.icinfo.lpsp.wechat.wxsdk.token.TokenManager;
import com.icinfo.lpsp.wechat.wxsdk.token.bean.Token;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 获取 Access Token
 * <p>
 * Created by wangxiao on 2016/11/23.
 */
@Controller
@RequestMapping("/token")
public class TokenController {

    /**
     * 获取 AccessToken
     *
     * @return AccessToken
     * @throws Exception
     */
    @RequestMapping(value = "/fetch", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String fetchAccessToken() throws Exception {
        Token token = TokenManager.getToken(ConfigConstant.APP_ID_LIANLIAN, ConfigConstant.APP_SECRET_LIANLIAN);
        return token.getAccess_token();
    }
}
