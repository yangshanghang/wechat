package com.icinfo.lpsp.wechat.api.controller;

import com.icinfo.lpsp.wechat.api.service.IMessageService;
import com.icinfo.lpsp.wechat.common.remote.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 消息API控制器
 * Created by yushunwei on 2017-05-18.
 */
@RequestMapping("/api/message/")
@Controller
public class MessageController {

    /**
     * 注入消息service
     */
    @Autowired
    private IMessageService messageService;


    /**
     * 描述：发送模板
     *
     * @param map 数据
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/template/send", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse send(@RequestBody Map<String, Object> map) throws Exception {
        return messageService.sendTemplate(map);
    }
}
