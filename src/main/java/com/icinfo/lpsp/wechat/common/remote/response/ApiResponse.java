/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author YuShunWei
 * @date 2016年3月26日
 * @version 1.0
 */
package com.icinfo.lpsp.wechat.common.remote.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * 描述: api响应 .<br>
 *
 * @author YuShunWei
 * @date 2016年3月26日
 */
public class ApiResponse<T> implements Serializable {

    private static final long serialVersionUID = -2021616574750699040L;

    // 成功编码
    public static final String SUCCESS_CODE = "00";

    // 成功信息
    public static final String SUCCESS_MSG = "成功";

    // 参数缺失编码
    public static final String FAIL_MISS_PARAM_CODE = "97";

    // 参数缺失信息
    public static final String FAIL_MISS_PARAM_MSG = "参数缺失";

    // 参数类型错误编码
    public static final String FAIL_MISMATCH_PARAM_TYPE_CODE = "98";

    // 参数类型错误信息
    public static final String FAIL_MISMATCH_PARAM_TYPE_MSG = "参数类型错误";

    // 失败编码
    public static final String FAIL_CODE = "99";

    // 失败信息
    public static final String FAIL_MSG = "失败";

    // 请求结果编码
    private String code;

    // 请求结果信息
    private String msg;

    // 描述信息
    private String description;

    // 业务数据
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public ApiResponse() {

    }

    /**
     * 自定义构造函数-调用成功
     *
     * @param t 业务数据
     */
    public ApiResponse(T t) {
        this.code = SUCCESS_CODE;
        this.msg = SUCCESS_MSG;
        this.data = t;
    }

    /**
     * 自定义构造函数-调用失败
     *
     * @param code 错误编码
     * @param msg  错误信息
     */
    public ApiResponse(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ApiResponse(String code, String msg, String description) {
        this.code = code;
        this.msg = msg;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
