package com.icinfo.lpsp.wechat.base.resolver;

import com.alibaba.fastjson.JSONObject;
import com.icinfo.lpsp.wechat.common.constant.BizConstant;
import com.icinfo.lpsp.wechat.common.constant.ConfigConstant;
import com.icinfo.lpsp.wechat.common.remote.api.UUserAPI;
import com.icinfo.lpsp.wechat.common.remote.response.UUserApiResponse;
import com.icinfo.lpsp.wechat.common.util.DateUtils;
import com.icinfo.lpsp.wechat.wxsdk.base.BaseResult;
import com.icinfo.lpsp.wechat.wxsdk.message.bean.Data;
import com.icinfo.lpsp.wechat.wxsdk.message.bean.TemplateMessage;
import com.icinfo.lpsp.wechat.wxsdk.message.resolver.SubscribeEventResolver;
import com.icinfo.lpsp.wechat.wxsdk.template.TemplateMessageManager;
import com.icinfo.lpsp.wechat.wxsdk.token.TokenManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

/**
 * 关注事件解析器
 * Created by yushunwei on 2017/3/7.
 */
public class LpspSubscribeEventResolver extends SubscribeEventResolver {

    private static Logger logger = LoggerFactory.getLogger(LpspSubscribeEventResolver.class);

    /**
     * 关注事件回复，回复模板消息
     *
     * @param message 需要处理的原始事件
     * @return 回复模板消息结果
     * @throws Exception
     */
    @Override
    public String resolve(HashMap<String, Object> message) throws Exception {
        // 1.判断微信用户是否绑定联连账号
        String openId = message.get("FromUserName").toString();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("openId", openId);
        UUserApiResponse response = UUserAPI.getUserInfo(jsonObject);

        // 2.构造模板消息对象
        TemplateMessage templateMessage = new TemplateMessage();
        templateMessage.setTemplate_id(BizConstant.SUBSCRIBE_TEMPLATE_ID);
        templateMessage.setTouser(openId);
        Data keyword3 = new Data(DateUtils.getDate("HH:mm"), "#aaaaaa");
        if (response.isSuccess()) {
            // 3.若已绑定，推送“再次关注”模板消息
            BizConstant.SUBSCRIBE_TEMPLATE_MSG_BOUND.put("keyword3", keyword3);
            templateMessage.setData(BizConstant.SUBSCRIBE_TEMPLATE_MSG_BOUND);
        } else {
            // 4.若未绑定，推送“提示绑定”模板消息
            templateMessage.setUrl(ConfigConstant.UUSER_SERVER_URL + "/external/doEnSetPhone.do?mark=1&openId=" + openId);
            BizConstant.SUBSCRIBE_TEMPLATE_MSG_UNBOUND.put("keyword3", keyword3);
            templateMessage.setData(BizConstant.SUBSCRIBE_TEMPLATE_MSG_UNBOUND);
        }

        //5.发送模板消息
        BaseResult result = TemplateMessageManager.sendTemplate(TokenManager.getToken(ConfigConstant.APP_ID_LIANLIAN, ConfigConstant.APP_SECRET_LIANLIAN).getAccess_token(), templateMessage);
        if (!result.isSuccess()) {
            logger.error("关注模板消息发送失败：{}", result.getErrcode() + ":" + result.getErrmsg());
        }
        return result.getErrcode();
    }
}
