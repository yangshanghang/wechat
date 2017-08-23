package com.icinfo.lpsp.wechat.common.controller;

import com.icinfo.lpsp.wechat.system.model.Manager;
import org.jasig.cas.client.authentication.AttributePrincipal;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 自定义基础控制器
 * Created by wangxiao on 2016/10/10.
 */
public class BaseController extends com.icinfo.framework.core.web.BaseController {

    /**
     * 获取单点登录用户
     *
     * @param request http请求
     * @return 单点登录用户
     * @throws Exception
     */
    protected Manager getCASSysUser(HttpServletRequest request) throws Exception {
        // 1.获取单点登录用户信息
        AttributePrincipal principal = (AttributePrincipal) request.getUserPrincipal();
        Map<String, Object> attribute = principal.getAttributes();

        // 2.封装用户对象
        Manager casUser = new Manager();
        casUser.setUserName((String) attribute.get("name"));
        casUser.setLoginName((String) attribute.get("username"));
        casUser.setMobile((String) attribute.get("phonenum"));
        casUser.setUserId((String) attribute.get("userUniqueId"));

        // 3.返回
        return casUser;
    }
}
