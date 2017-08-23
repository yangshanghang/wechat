/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.lpsp.wechat.manage.service;

import com.icinfo.framework.core.service.BaseService;
import com.icinfo.lpsp.wechat.manage.model.Template;

/**
 * 描述:  WECHAT_TEMPLATE 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年05月19日
 */
public interface ITemplateService extends BaseService {

    /**
     * 描述：根据业务类型获取模板配置
     *
     * @return
     * @throws Exception
     */
    Template selectByBusinessType(String businessType) throws Exception;
}