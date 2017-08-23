package com.icinfo.lpsp.wechat.api.controller;

import com.icinfo.lpsp.wechat.common.constant.ConfigConstant;
import com.icinfo.lpsp.wechat.wxsdk.ticket.TicketManager;
import com.icinfo.lpsp.wechat.wxsdk.ticket.bean.Ticket;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 获取 JS Ticket
 * <p>
 * Created by wangxiao on 2016/11/24.
 */
@Controller
@RequestMapping("/ticket")
public class TicketController {

    /**
     * 获取 js-ticket
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/fetch", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String getJsTicket() throws Exception {
        Ticket ticket = TicketManager.getTicket(ConfigConstant.APP_ID_LIANLIAN, ConfigConstant.APP_SECRET_LIANLIAN);
        // ticket获取失败处理
        if (ticket == null || !ticket.isSuccess()) {
            return "";
        }
        return ticket.getTicket();
    }
}
