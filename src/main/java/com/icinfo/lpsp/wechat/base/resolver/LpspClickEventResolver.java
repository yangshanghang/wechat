package com.icinfo.lpsp.wechat.base.resolver;

import com.icinfo.lpsp.wechat.common.constant.BizConstant;
import com.icinfo.lpsp.wechat.wxsdk.common.utils.XMLUtils;
import com.icinfo.lpsp.wechat.wxsdk.message.bean.TextMessage;
import com.icinfo.lpsp.wechat.wxsdk.message.resolver.ClickEventResolver;

import java.util.HashMap;

/**
 * 消息-点击事件处理器
 * Created by yushunwei on 2017/3/7.
 */
public class LpspClickEventResolver extends ClickEventResolver {
    /**
     * 处理
     *
     * @param message 需要处理的原始消息
     * @return 处理结果
     * @throws Exception
     */
    @Override
    public String resolve(HashMap<String, Object> message) throws Exception {
        String eventKey = this.getEventKey(message);

        // 服务介绍按钮点击事件
        if (eventKey.equals(BizConstant.FWJS_BUTTON_KEY)) {
            TextMessage respMessage = new TextMessage();
            setBaseMessage(respMessage, message);
            respMessage.setMsgType(MESSAGE_TEXT);
            respMessage.setContent(BizConstant.FWJS_TEXT_MSG);
            return XMLUtils.parseXml(respMessage);
        } else {
            return null;
        }
    }
}
