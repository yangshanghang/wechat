package com.icinfo.lpsp.wechat.api.service;

import com.icinfo.lpsp.wechat.common.remote.response.ApiResponse;

import java.util.Map;

/**
 * 描述:消息Service接口.
 */
public interface IMessageService {

    /**
     * 描述：发送模板
     *
     * @param map 数据
     * @return
     * @throws Exception
     */
    ApiResponse sendTemplate(Map<String, Object> map) throws Exception;
}
