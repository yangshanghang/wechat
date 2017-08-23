package com.icinfo.lpsp.wechat.core.service.impl;

import com.icinfo.lpsp.wechat.common.constant.ConfigConstant;
import com.icinfo.lpsp.wechat.core.service.ILpspWechatService;
import com.icinfo.lpsp.wechat.base.message.LpspMessageRouter;
import com.icinfo.lpsp.wechat.wxsdk.common.utils.XMLUtils;
import com.icinfo.lpsp.wechat.wxsdk.ticket.bean.Ticket;
import com.icinfo.lpsp.wechat.wxsdk.ticket.TicketManager;
import com.icinfo.lpsp.wechat.wxsdk.token.bean.Token;
import com.icinfo.lpsp.wechat.wxsdk.token.TokenManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 微信Service 实现类
 *
 * Creted by wangxiao on 2016/8/28.
 */
@Service
@Lazy(false)
public class LpspWechatServiceImpl implements ILpspWechatService {

    /**
     * 日志
     */
    private Logger logger = LoggerFactory.getLogger(LpspWechatServiceImpl.class);

    /**
     * 消息转换器
     */
    @Autowired
    private LpspMessageRouter lpspMessageRouter;

    /**
     * 处理消息
     *
     * @param request 请求
     * @return 处理结果
     * @throws Exception
     */
    @Override
    public String processRequest(HttpServletRequest request) throws Exception {
        // 调用parseXml方法解析请求消息
        Map<String, String> requestMap = XMLUtils.parseXml(request);

        String message = lpspMessageRouter.route(requestMap);

        return message;
    }

    /**
     * 定时刷新token和ticket
     * @throws Exception
     */
    @Override
    @Scheduled(fixedRate = 7_000_000)
    public void refreshScheduled() throws Exception {
        Token accessToken = TokenManager.getToken(ConfigConstant.APP_ID_LIANLIAN, ConfigConstant.APP_SECRET_LIANLIAN);
        Ticket ticket = TicketManager.getTicket(ConfigConstant.APP_ID_LIANLIAN, ConfigConstant.APP_SECRET_LIANLIAN);
        logger.info(">>>>>>>>>>>> 定时刷新token和ticket>>>>>>>>>>");
        logger.info(accessToken.getAccess_token());
        logger.info(ticket.getTicket());
    }
}
