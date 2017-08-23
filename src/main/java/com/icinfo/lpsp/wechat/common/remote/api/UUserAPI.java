package com.icinfo.lpsp.wechat.common.remote.api;

import com.alibaba.fastjson.JSONObject;
import com.icinfo.lpsp.wechat.common.constant.ConfigConstant;
import com.icinfo.lpsp.wechat.common.constant.Constants;
import com.icinfo.lpsp.wechat.common.remote.client.HttpClient;
import com.icinfo.lpsp.wechat.common.remote.response.UUserApiResponse;
import com.icinfo.lpsp.wechat.common.util.JSONUtils;
import com.icinfo.lpsp.wechat.common.util.sm4.SM4Utils;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * 联连用户接口调用API
 */
public class UUserAPI extends BaseAPI {
    /**
     * 获取联连用户信息
     *
     * @param jsonObject 参数
     *                   openId 微信号唯一标识
     *                   phone  手机号
     *                   uniId 联连用户唯一标识
     *                   username 联连账号用户名
     * @return
     * @throws Exception
     */
    public static UUserApiResponse getUserInfo(JSONObject jsonObject) throws Exception {
        HttpUriRequest request = RequestBuilder.post()
                .setConfig(requestConfig)
                .setHeader(jsonHeader)
                .setUri(ConfigConstant.UUSER_SERVER_URL + "/external/doGetUserInfo.do")
                .setEntity(new StringEntity(JSONUtils.parse(jsonObject)))
                .build();
        Map<String, String> requestInfo = new HashMap<>();
        requestInfo.put("url", request.getURI().toString());
        requestInfo.put("params", JSONUtils.parse(jsonObject));
        String info = HttpClient.executeStringResult(request, requestInfo);
        SM4Utils sm4Utils = new SM4Utils();
        sm4Utils.setSecretKey(Constants.USER_INTERFACE_SM4_SECRET_KEY);
        sm4Utils.setHexString(false);
        return JSONUtils.parse(sm4Utils.decryptData_ECB(info), UUserApiResponse.class);
    }
}
