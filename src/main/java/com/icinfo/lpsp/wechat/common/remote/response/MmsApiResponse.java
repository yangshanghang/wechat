/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author YuShunWei
 * @date 2016年3月26日
 * @version 1.0
 */
package com.icinfo.lpsp.wechat.common.remote.response;

import com.icinfo.lpsp.wechat.common.remote.bean.PageMmsMessage;

import java.io.Serializable;

/**
 * 描述: Api响应 .<br>
 *
 * @author YangShangHang
 * @date 2017/4/26
 */
public class MmsApiResponse implements Serializable {

    private static final long serialVersionUID = -2021616574750699040L;

    /**
     * 接口返回成功标识
     */
    private static final String SUCCESS_CODE = "00";

    // 请求结果编码
    private String code;

    // 请求结果信息
    private String msg;

    // 描述信息
    private String description;

    // 业务数据
    private  PageMmsMessage data;

    public boolean isSuccess(){
        return code.equals(SUCCESS_CODE);
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

    public PageMmsMessage getData() {
        return data;
    }

    public void setData(PageMmsMessage data) {
        this.data = data;
    }
}
