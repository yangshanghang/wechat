package com.icinfo.lpsp.wechat.api.controller;

import com.icinfo.lpsp.wechat.common.util.JSONUtils;
import com.icinfo.lpsp.wechat.wxsdk.jssign.JsSdkSignManager;
import com.icinfo.lpsp.wechat.wxsdk.jssign.bean.JSSign;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;

/**
 * jssdk签名控制器
 *
 * Created by wangxiao on 2016/11/25.
 */
@Controller
@RequestMapping("/jssdksign")
public class JsSdkSignController {

    /**
     * js sdk签名
     *
     * @param url 当前页面的url
     * @param response 响应对象
     * @throws Exception
     */
    @RequestMapping(value = "/sign", method = RequestMethod.GET)
    public void sign(@RequestParam(value = "url", required = true) String url, HttpServletResponse response) throws Exception {
        JSSign sign = JsSdkSignManager.sign(url);
        response.getWriter().write(JSONUtils.parse(sign));
    }
}
