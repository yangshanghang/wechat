package com.icinfo.lpsp.wechat.common.interceptor;


import com.icinfo.lpsp.wechat.common.constant.Constants;
import com.icinfo.lpsp.wechat.common.util.HttpUtils;
import com.icinfo.lpsp.wechat.system.enums.EManager;
import com.icinfo.lpsp.wechat.system.model.Manager;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户权限校验
 * Created by wangxiao on 2017/1/11.
 */
public class ManagerAuthorityInterceptor extends HandlerInterceptorAdapter {

    /**
     * 权限校验
     *
     * @param request 请求
     * @param response 响应
     * @param handler 处理器
     * @return 校验结果
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Manager manager = (Manager) request.getSession().getAttribute(Constants.SESSION_MANAGER_INFO);

        // 用户为空, 或异常状态的账户
        if (manager == null || !EManager.STATUS_VALID.getValue().equals(manager.getStatus())) {
            if (HttpUtils.isAjax(request)) {
                HttpUtils.writeError(response, Constants.LOGIN_ERROR_INFO, HttpStatus.UNAUTHORIZED.value());
            } else {
                // 未登录
                response.sendRedirect("/");
            }
            return false;
        }
        return true;
    }
}
