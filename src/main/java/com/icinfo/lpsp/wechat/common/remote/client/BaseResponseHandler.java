package com.icinfo.lpsp.wechat.common.remote.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * 基础响应处理器
 * Created by yushunwei on 2016/8/12.
 */
public class BaseResponseHandler {

    private static Logger logger = LoggerFactory.getLogger(BaseResponseHandler.class);

    // 请求信息
    protected Map<String, String> requestInfo;

    /**
     * 打印响应信息
     *
     * @param response 接口响应
     * @throws Exception
     */
    protected void printResponse(String response) {
        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        logger.info("接口请求地址：");
        logger.info(requestInfo.get("url"));
        logger.info("接口请求参数：");
        logger.info(requestInfo.get("params"));
        logger.info("接口返回：");
        logger.info(response);
        logger.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
    }

    /**
     * 打印接口调用错误信息
     *
     * @param error 接口调用错误信息
     */
    protected void printError(String error) {
        logger.error(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        logger.info("接口请求地址：");
        logger.info(requestInfo.get("url"));
        logger.info("接口请求参数：");
        logger.info(requestInfo.get("params"));
        logger.error("接口返回：");
        logger.error(error);
        logger.error("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
    }

    public Map<String, String> getRequestInfo() {
        return requestInfo;
    }

    public void setRequestInfo(Map<String, String> requestInfo) {
        this.requestInfo = requestInfo;
    }
}
