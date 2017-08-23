package com.icinfo.lpsp.wechat.core.service;

import javax.servlet.http.HttpServletRequest;

/**
 * 微信Service
 *
 * Created by wangxiao on 2016/8/28.
 */
public interface ILpspWechatService {

    /**
     * 处理消息
     *
     * @param request 请求
     * @return 处理结果
     * @throws Exception
     */
    String processRequest(HttpServletRequest request) throws Exception;

    /**
     * 定时刷新token和ticket
     * @throws Exception
     */
    void refreshScheduled() throws Exception;
}
