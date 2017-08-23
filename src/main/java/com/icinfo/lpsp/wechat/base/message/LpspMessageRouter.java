package com.icinfo.lpsp.wechat.base.message;

import com.icinfo.lpsp.wechat.base.resolver.*;
import com.icinfo.lpsp.wechat.wxsdk.message.MessageRouter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 联连服务号消息路由器
 * <p>
 * Created by wangxiao on 2016/8/28.
 */
@Component
public class LpspMessageRouter extends MessageRouter {

    /**
     * 消息转换器
     */
    private static Map<String, Class> routerMap = new HashMap<String, Class>() {
        {
            put("eventsubscribe", LpspSubscribeEventResolver.class);
            put("text", LpspTextMessageResolver.class);
            put("eventclick", LpspClickEventResolver.class);
            put("image", LpspImageMessageResolver.class);
            put("voice", LpspVoiceMessageResolver.class);
        }
    };

    /**
     * 获取消息转换器
     *
     * @param clazzKey 消息转换器key
     * @return 消息转换器
     */
    @Override
    protected Class getResoler(String clazzKey) {
        return routerMap.get(clazzKey);
    }
}
