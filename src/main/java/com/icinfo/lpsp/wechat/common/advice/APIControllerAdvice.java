/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author YuShunWei
 * @date 2016年3月7日
 * @version 1.0
 */
package com.icinfo.lpsp.wechat.common.advice;

import com.icinfo.lpsp.wechat.common.remote.response.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * 异常处理
 */
@ControllerAdvice({"com.icinfo.lpsp.wechat.api"})
public class APIControllerAdvice {

    public static final Logger logger = LoggerFactory.getLogger(APIControllerAdvice.class);

    /**
     * API接口调用异常处理
     *
     * @param e 异常信息
     * @return API调用结果对象
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ApiResponse handle(HttpServletRequest request, Exception e) throws Exception {
        logger.error("api接口调用异常: "+request.getRequestURI()+": ",e);
        return new ApiResponse(ApiResponse.FAIL_CODE, ApiResponse.FAIL_MSG, "微信平台接口响应异常");
    }
}
