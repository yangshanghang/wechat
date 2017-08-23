/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.lpsp.wechat.manage.service.impl;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.lpsp.wechat.manage.mapper.TemplateMapper;
import com.icinfo.lpsp.wechat.manage.model.Template;
import com.icinfo.lpsp.wechat.manage.service.ITemplateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:  WECHAT_TEMPLATE 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年05月19日
 */
@Service
public class TemplateServiceImpl extends MyBatisServiceSupport implements ITemplateService {
    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(TemplateServiceImpl.class);

    @Autowired
    private TemplateMapper templateMapper;


    /**
     * 描述：根据业务类型获取模板配置
     *
     * @param businessType 业务类型
     * @return
     * @throws Exception
     */
    @Override
    public Template selectByBusinessType(String businessType) throws Exception {
        Template template = new Template();
        template.setBusinessType(businessType);
        return templateMapper.selectOne(template);
    }
}