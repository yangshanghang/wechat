/*
 *  Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.lpsp.wechat.system.controller;

import com.icinfo.lpsp.wechat.common.constant.Constants;
import com.icinfo.lpsp.wechat.common.controller.BaseController;
import com.icinfo.lpsp.wechat.system.model.Manager;
import com.icinfo.lpsp.wechat.system.service.IManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * 描述:  用户登录控制.<br>
 *
 * @author xiajunwei
 * @date 2016年05月18日
 */
@Controller
@SessionAttributes(Constants.SESSION_MANAGER_INFO)
public class LoginController extends BaseController {
    private final static Logger logger = LoggerFactory.getLogger(LoginController.class);

    /**
     * 单点退出地址
     */
    @Value("${user.logout.url}")
    private String userLogoutUrl;

    /**
     * 注入用户服务
     */
    @Autowired
    private IManagerService managerService;

    /**
     * 单点登录
     *
     * @param request 请求
     * @param model   模型
     * @return 登录后首页
     * @throws Exception
     */
    @RequestMapping(value = "/cas/login", method = RequestMethod.GET)
    public String login(HttpServletRequest request, Model model, HttpSession session, SessionStatus sessionStatus) throws Exception {
        //1.根据id获取用户对象
        Manager manager = managerService.getManagerById(getCASSysUser(request).getUserId());
        //2.若用户不为空，则设置session
        if (manager != null) {
            model.addAttribute(Constants.SESSION_MANAGER_INFO, manager);
        } else {
            // 1.删除session中数据
            sessionStatus.setComplete();
            session.invalidate();
            return "redirect:" + userLogoutUrl+"?noauth=1";
        }
        return "redirect:/admin/index";
    }

    /**
     * 单点退出
     *
     * @param session       会话
     * @param sessionStatus 会话状态
     * @return 登录页面
     */
    @RequestMapping(value = "/admin/logout", method = RequestMethod.GET)
    public String logout(HttpSession session, SessionStatus sessionStatus) {
        return processLogout(session, sessionStatus);

    }

    /**
     * 执行单点退出
     *
     * @param session       会话
     * @param sessionStatus 会话状态
     * @return 登录页面
     */
    private String processLogout(HttpSession session, SessionStatus sessionStatus) {
        // 1.删除session中数据
        sessionStatus.setComplete();
        session.invalidate();
        return "redirect:" + userLogoutUrl;
    }
}
