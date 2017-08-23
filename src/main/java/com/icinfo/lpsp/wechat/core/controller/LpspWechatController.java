package com.icinfo.lpsp.wechat.core.controller;

import com.icinfo.lpsp.wechat.common.constant.ConfigConstant;
import com.icinfo.lpsp.wechat.core.service.ILpspWechatService;
import com.icinfo.lpsp.wechat.wxsdk.controller.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 微信核心控制类
 * <p>
 * Created by wangxiao on 2016/8/28.
 */
@RestController
@RequestMapping("/core")
public class LpspWechatController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(LpspWechatController.class);

    /**
     * 微信Service
     */
    @Autowired
    private ILpspWechatService lpspWechatService;

    /**
     * 开发者接入
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/service", method = RequestMethod.GET, produces = "text/plain")
    public String validate(HttpServletRequest request) throws Exception {
        if (isWeChatCall(request, ConfigConstant.TOKEN_LIANLIAN)) {
            String echostr = request.getParameter("echostr");
            logger.info("接入成功！echostr:" + echostr);
            return echostr;
        }
        return "error";
    }

    /**
     * 处理消息
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/service", method = RequestMethod.POST, produces = "application/xml;charset=UTF-8")
    public String processMsg(HttpServletRequest request) throws Exception {
        if (!isWeChatCall(request, ConfigConstant.TOKEN_LIANLIAN)) {
            return "";
        }
        return lpspWechatService.processRequest(request);
    }
}
