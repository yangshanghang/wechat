/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.lpsp.wechat.manage.controller.admin;

import com.icinfo.framework.core.web.BaseController;
import com.icinfo.lpsp.wechat.manage.service.ITemplateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述:  WECHAT_TEMPLATE 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年05月19日
 */
@RequestMapping("/template")
@Controller
public class TemplateController extends BaseController {
    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(TemplateController.class);

    /**
     * 注入模板service
     */
    @Autowired
    private ITemplateService templateService;
}