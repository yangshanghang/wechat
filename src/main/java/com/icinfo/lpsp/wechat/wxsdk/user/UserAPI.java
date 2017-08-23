package com.icinfo.lpsp.wechat.wxsdk.user;

import com.icinfo.lpsp.wechat.wxsdk.base.BaseAPI;
import com.icinfo.lpsp.wechat.wxsdk.client.HttpClientExecutor;
import com.icinfo.lpsp.wechat.wxsdk.common.utils.StringUtils;
import com.icinfo.lpsp.wechat.wxsdk.user.bean.Users;
import org.apache.http.client.methods.RequestBuilder;

/**
 * 用户管理APi
 */
public class UserAPI extends BaseAPI {


    /**
     * 获取用户列表
     *
     * @param access_token 接口调用access_token
     * @param next_openid  第一个拉取的OPENID，不填默认从头开始拉取
     * @return 接口调用结果
     * @throws Exception
     */
    public static Users getUserList(String access_token, String next_openid) throws Exception {
        RequestBuilder requestBuilder = RequestBuilder.get()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/cgi-bin/user/get")
                .addParameter(PARAM_ACCESS_TOKEN, access_token);
        if (StringUtils.isNotBlank(next_openid)) {
            requestBuilder.addParameter("next_openid", next_openid);
        }
        return HttpClientExecutor.executeJsonResult(requestBuilder.build(), Users.class);
    }
}
