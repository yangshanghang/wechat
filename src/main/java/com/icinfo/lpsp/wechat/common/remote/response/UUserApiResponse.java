package com.icinfo.lpsp.wechat.common.remote.response;

import com.icinfo.lpsp.wechat.common.remote.bean.UUserInfo;

import java.io.Serializable;

/**
 * 联连用户接口响应对象
 */
public class UUserApiResponse  implements Serializable {

    private static final long serialVersionUID = 783193943524204647L;

    /**
     * 接口返回成功标识
     */
    private static final String SUCCESS_CODE = "0";

    /**
     * 状态码
     */
    private String retcode;

    /**
     * 错误信息
     */
    private String retmsg;

    /**
     * 用户信息
     */
    private UUserInfo userInfo;

    /**
     * 接口
     * @return 接口调用是否成功
     */
    public boolean isSuccess(){
        return retcode.equals(SUCCESS_CODE);
    }

    public String getRetcode() {
        return retcode;
    }

    public void setRetcode(String retcode) {
        this.retcode = retcode;
    }

    public String getRetmsg() {
        return retmsg;
    }

    public void setRetmsg(String retmsg) {
        this.retmsg = retmsg;
    }

    public UUserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UUserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
