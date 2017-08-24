package com.icinfo.lpsp.wechat.core.controller;

import com.icinfo.lpsp.wechat.common.constant.ConfigConstant;
import com.icinfo.lpsp.wechat.wxsdk.oauth.OauthAPI;
import com.icinfo.lpsp.wechat.wxsdk.oauth.bean.WechatOauth2Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * 描述: 菜单控制器 .<br>
 *
 * @author YangShangHang
 * @date 2017/5/18
 */
@Controller("coreMenuController")
@RequestMapping("menu")
public class MenuController {

    public static final Logger logger = LoggerFactory.getLogger(MenuController.class);

    /**
     * “我的消息”菜单点击后页面跳转
     *
     * @param request 请求
     * @return 跳转页面
     * @throws Exception
     */
    @RequestMapping(value = "/mymessage", method = RequestMethod.GET)
    public String myMessage(HttpServletRequest request, Model model) throws Exception {
        WechatOauth2Token oauth2AccessToken = OauthAPI.getOauth2AccessToken(ConfigConstant.APP_ID_LIANLIAN, ConfigConstant.APP_SECRET_LIANLIAN, request);

        if (!oauth2AccessToken.isSuccess()) {
            logger.error("通过code换取网页授权access_token失败！" + oauth2AccessToken.getErrcode() + oauth2AccessToken.getErrmsg());
            model.addAttribute("errorMsg", "打开页面失败，请重试！");
            return "wechat/error";
        }

        // 进入跳转页面
        return "redirect:http://www.baidu.com";
    }


    /**
     * 绑定联连
     *
     * @param request 请求
     * @return 跳转页面
     * @throws Exception
     */
    @RequestMapping(value = "/bindll", method = RequestMethod.GET)
    public String bindLl(HttpServletRequest request, Model model) throws Exception {
        // 1.获取网页授权信息
        WechatOauth2Token oauth2AccessToken = OauthAPI.getOauth2AccessToken(ConfigConstant.APP_ID_LIANLIAN, ConfigConstant.APP_SECRET_LIANLIAN, request);

        // 2.获取失败，进错误页面
        if (!oauth2AccessToken.isSuccess()) {
            logger.error("通过code换取网页授权access_token失败！" + oauth2AccessToken.getErrcode() + oauth2AccessToken.getErrmsg());
            model.addAttribute("errorMsg", "打开页面失败，请重试！");
            return "wechat/error";
        }

        // 3.进入跳转页面
        return "redirect:http://www.baidu.com";
    }
}
