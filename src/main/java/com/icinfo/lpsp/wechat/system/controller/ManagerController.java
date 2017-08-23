/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.lpsp.wechat.system.controller;

import com.icinfo.framework.core.web.BaseController;
import com.icinfo.lpsp.wechat.system.service.IManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 描述:  LPSP_WECHAT_MANAGER 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年04月27日
 */
@Controller
public class ManagerController extends BaseController {
    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(ManagerController.class);

    @Autowired
    private IManagerService managerService;
}