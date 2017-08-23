package com.icinfo.lpsp.wechat.base.resolver;

import com.icinfo.lpsp.wechat.wxsdk.base.BaseMessage;
import com.icinfo.lpsp.wechat.wxsdk.common.utils.XMLUtils;
import com.icinfo.lpsp.wechat.wxsdk.message.resolver.VoiceMessageResolver;

import java.util.HashMap;

/**
 * 语音消息
 * Created by yushunwei on 2017/3/27.
 */
public class LpspVoiceMessageResolver extends VoiceMessageResolver {
    /**
     * 语音消息直接转发客服
     *
     * @param message 需要处理的原始消息
     * @return 转发客服消息
     * @throws Exception
     */
    @Override
    public String resolve(HashMap<String, Object> message) throws Exception {
        BaseMessage respMessage = createBaseMessage(message);
        respMessage.setMsgType(TRANSFER_CUSTOMER_SERVICE);
        return XMLUtils.parseXml(respMessage);
    }
}
