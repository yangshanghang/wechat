package com.icinfo.lpsp.wechat.common.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * 可配置常量
 * <p>
 * Created by wangxiao on 2016/11/24.
 */
@Component
@Lazy(false)
public class ConfigConstant {
    /**
     * 联连服务号 appID
     */
    public static String APP_ID_LIANLIAN;

    /**
     * 联连服务号 appSecret
     */
    public static String APP_SECRET_LIANLIAN;

    /**
     * 联连服务号 token
     */
    public static String TOKEN_LIANLIAN;

    /**
     * 联连用户系统URL
     */
    public static String UUSER_SERVER_URL;

    /**
     * 监管系统URL
     */
    public static String CS_SERVER_URL;

    /**
     * 消息管理平台URL
     */
    public static String MMS_SERVER_URL;

    @Value("${lianlian.appid}")
    public void setAppIdLianlian(String appIdLianlian) {
        APP_ID_LIANLIAN = appIdLianlian;
    }

    @Value("${lianlian.appsecret}")
    public void setAppSecretLianlian(String appSecretLianlian) {
        APP_SECRET_LIANLIAN = appSecretLianlian;
    }

    @Value("${lianlian.token}")
    public void setTokenLianlian(String tokenLianlian) {
        TOKEN_LIANLIAN = tokenLianlian;
    }

    @Value("${uuser.server.url}")
    public void setUuserServerurl(String uuserServerurl) {
        UUSER_SERVER_URL = uuserServerurl;
    }

    @Value("${cs.server.url}")
    public void setCsServerUrl(String csServerUrl) {
        CS_SERVER_URL = csServerUrl;
    }

    @Value(("${mms.server.url}"))
    public void setMmsServerUrl(String mmsServerUrl){
        MMS_SERVER_URL = mmsServerUrl;
    }
}
