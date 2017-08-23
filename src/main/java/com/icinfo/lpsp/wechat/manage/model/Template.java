/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.lpsp.wechat.manage.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import javax.persistence.*;

/**
 * 描述:  WECHAT_TEMPLATE 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年05月19日
 */
@Table(name = "WECHAT_TEMPLATE")
public class Template implements Serializable {
    /**
     * 唯一标识
     */
    @Id
    @Column(name = "ID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String id;

    /**
     * 模板标识
     */
    @Column(name = "WT_TEMPLATE_ID")
    private String templateId;

    /**
     * 业务类型
     */
    @Column(name = "WT_BUSINESS_TYPE")
    private String businessType;

    /**
     * 配置内容
     */
    @Column(name = "WT_CONTENT")
    private String content;

    private static final long serialVersionUID = 1L;

    /**
     * 获取唯一标识
     *
     * @return ID - 唯一标识
     */
    public String getId() {
        return id;
    }

    /**
     * 设置唯一标识
     *
     * @param id 唯一标识
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取模板标识
     *
     * @return WT_TEMPLATE_ID - 模板标识
     */
    public String getTemplateId() {
        return templateId;
    }

    /**
     * 设置模板标识
     *
     * @param templateId 模板标识
     */
    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    /**
     * 获取业务类型
     *
     * @return WT_BUSINESS_TYPE - 业务类型
     */
    public String getBusinessType() {
        return businessType;
    }

    /**
     * 设置业务类型
     *
     * @param businessType 业务类型
     */
    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    /**
     * 获取配置内容
     *
     * @return WT_CONTENT - 配置内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置配置内容
     *
     * @param content 配置内容
     */
    public void setContent(String content) {
        this.content = content;
    }
}