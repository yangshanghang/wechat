package com.icinfo.lpsp.wechat.common.constant;

import com.icinfo.lpsp.wechat.wxsdk.message.bean.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 业务常量
 * <p>
 * Created by wangxiao on 2016/11/29.
 */
public class BizConstant {

    /**
     * 处理失败消息
     */
    public static final String RESOLVE_FAIL_MSG = "处理失败，请重试！";

    /**
     * 服务介绍按钮KEY
     */
    public static final String FWJS_BUTTON_KEY = "V1001_FWJS";

    /**
     * 服务介绍按钮点击回复文本内容
     */
    public static final String FWJS_TEXT_MSG = "企信联连为企业提供以下服务：\n" +
            "•  接收来自工商的消息通知\n" +
            "•  查阅来自工商的公务文书\n" +
            "•  接收本企业信用提醒消息\n" +
            "•  订阅关注企业信用信息\n" +
            "•  工商部门咨询电话查询";

    /**
     * 法人证书文本接收
     */
    public static final String FRZS_TEXT_RECEIVE = "法人证书";

    /**
     * 下载证书文本接收
     */
    public static final String XZZS_TEXT_RECEIVE = "下载证书";

    /**
     * 法人证书图文消息素材ID
     */
    public static final String FRZS_MEDIA_ID = "iv81hcDeUcTh-vWe8-gCxlfrJ0jPoANV_pb6e7vu_8w";

    /**
     * 下载证书图文消息素材ID
     */
    public static final String XZZS_MEDIA_ID = "iv81hcDeUcTh-vWe8-gCxg0Ptv5dHxTlqjSJxqVTrNA";

    /**
     * 关注事件自动回复模板消息id
     */
    public static final String SUBSCRIBE_TEMPLATE_ID = "A0kpXzK7Ffhop8_l_TyIItWh8Qua1eVQB05kvCba4so";

    /**
     * 未绑定用户关注，推送的模板消息
     */
    public static final Map<String, Data> SUBSCRIBE_TEMPLATE_MSG_UNBOUND = new HashMap<String, Data>() {
        {
            put("first", new Data("立即绑定联连，接收企业抽查/年报/经营异常等消息提醒\n", "#FF0000"));
            put("keyword1", new Data("关注后绑定手机就可享受联连服务"));
            put("keyword2", new Data("未绑定联连"));
            put("remark", new Data("\n联连为企业提供以下服务：\n" +
                    "•  企业抽查提醒及抽查名单查询\n" +
                    "•  数字证书在线服务和消息通知\n" +
                    "•  接收/订阅企业信用警示/信用信息\n" +
                    "•  接收年报/异常/即时信息报送提醒"));
        }
    };

    /**
     * 已绑定用户再次关注，推送的模板消息
     */
    public static final Map<String, Data> SUBSCRIBE_TEMPLATE_MSG_BOUND = new HashMap<String, Data>() {
        {
            put("first", new Data("小联正在成长，努力为您提供更好的服务\n"));
            put("keyword1", new Data("欢迎回来"));
            put("keyword2", new Data("已绑定联连"));
            put("remark", new Data("\n联连为企业提供以下服务：\n" +
                    "•  企业抽查检查提醒和在线查询\n" +
                    "•  数字证书在线服务和消息通知\n" +
                    "•  接收/订阅企业信用警示/信用信息\n" +
                    "•  接收年报/异常/即时信息报送提醒", "#FF0000"));
        }
    };
}
