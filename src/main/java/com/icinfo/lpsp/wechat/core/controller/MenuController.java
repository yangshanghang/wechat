package com.icinfo.lpsp.wechat.core.controller;

import com.alibaba.fastjson.JSONObject;
import com.icinfo.lpsp.wechat.common.constant.ConfigConstant;
import com.icinfo.lpsp.wechat.common.remote.api.CsAPI;
import com.icinfo.lpsp.wechat.common.remote.api.UUserAPI;
import com.icinfo.lpsp.wechat.common.remote.response.UUserApiResponse;
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
        // 1.获取openId
        WechatOauth2Token oauth2AccessToken = OauthAPI.getOauth2AccessToken(ConfigConstant.APP_ID_LIANLIAN, ConfigConstant.APP_SECRET_LIANLIAN, request);

        if (!oauth2AccessToken.isSuccess()) {
            logger.error("通过code换取网页授权access_token失败！" + oauth2AccessToken.getErrcode() + oauth2AccessToken.getErrmsg());
            model.addAttribute("errorMsg", "打开页面失败，请重试！");
            return "wechat/error";
        }

        // 2.根据openId获取联连用户
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("openId", oauth2AccessToken.getOpenid());
        UUserApiResponse uUserApiResponse = UUserAPI.getUserInfo(jsonObject);
        if (uUserApiResponse.isSuccess()) {
            // 3.进消息列表页面
            return "redirect:/wechat/message/page/" + uUserApiResponse.getUserInfo().getPwdRecoverPhoneNum();
        }

        // 4.进联连用户绑定页面
        return "redirect:" + ConfigConstant.UUSER_SERVER_URL + "/external/doEnSetPhone.do?mark=1&openId=" + oauth2AccessToken.getOpenid();
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
        // 1.获取openId
        WechatOauth2Token oauth2AccessToken = OauthAPI.getOauth2AccessToken(ConfigConstant.APP_ID_LIANLIAN, ConfigConstant.APP_SECRET_LIANLIAN, request);

        if (!oauth2AccessToken.isSuccess()) {
            logger.error("通过code换取网页授权access_token失败！" + oauth2AccessToken.getErrcode() + oauth2AccessToken.getErrmsg());
            model.addAttribute("errorMsg", "打开页面失败，请重试！");
            return "wechat/error";
        }

        // 2.进联连用户重新绑定页面
        return "redirect:" + ConfigConstant.UUSER_SERVER_URL + "/external/doEnSetPhone.do?mark=2&openId=" + oauth2AccessToken.getOpenid();
    }

    /**
     * “抽查检查”菜单
     *
     * @param request 请求
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/gscheck", method = RequestMethod.GET)
    public String gsCheck(HttpServletRequest request, Model model) throws Exception {
        // 1.获取openId
        WechatOauth2Token oauth2AccessToken = OauthAPI.getOauth2AccessToken(ConfigConstant.APP_ID_LIANLIAN, ConfigConstant.APP_SECRET_LIANLIAN, request);
        if (!oauth2AccessToken.isSuccess()) {
            logger.error("通过code换取网页授权access_token失败！" + oauth2AccessToken.getErrcode() + oauth2AccessToken.getErrmsg());
            model.addAttribute("errorMsg", "打开页面失败，请重试！");
            return "wechat/error";
        }

        // 2.判断用户是否绑定，若未绑定则进联连用户绑定页面
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("openId", oauth2AccessToken.getOpenid());
        UUserApiResponse uUserApiResponse = UUserAPI.getUserInfo(jsonObject);
        if (!uUserApiResponse.isSuccess()) {
            return "redirect:" + ConfigConstant.UUSER_SERVER_URL + "/external/doEnSetPhone.do?mark=1&openId=" + oauth2AccessToken.getOpenid();
        }

        // 3.判断是否为联络员
        String liaisonMan = CsAPI.isLiaisonMan(uUserApiResponse.getUserInfo().getPwdRecoverPhoneNum()) ? "1" : "0";
        return "redirect:" + ConfigConstant.MMS_SERVER_URL + "/wechat/info/gscheck/search/" + uUserApiResponse.getUserInfo().getPwdRecoverPhoneNum() + "/" + oauth2AccessToken.getOpenid() + "/" + liaisonMan;
    }
}
