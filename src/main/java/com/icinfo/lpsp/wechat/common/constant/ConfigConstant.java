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
}
