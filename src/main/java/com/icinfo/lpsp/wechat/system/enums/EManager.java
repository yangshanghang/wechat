package com.icinfo.lpsp.wechat.system.enums;

/**
 * 管理员枚举
 * Created by wangxiao on 2017/1/11.
 */
public enum EManager {
    /**
     * 管理员状态: 失效
     */
    STATUS_INVALID("0", "失效"),
    /**
     * 管理员状态: 有效
     */
    STATUS_VALID("1", "有效");

    private String value;
    private String desc;

    EManager(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public String getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }
}
