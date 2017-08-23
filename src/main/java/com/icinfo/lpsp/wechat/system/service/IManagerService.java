/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.lpsp.wechat.system.service;

import com.icinfo.framework.core.service.BaseService;
import com.icinfo.lpsp.wechat.system.model.Manager;

/**
 * 描述:  LPSP_WECHAT_MANAGER 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年04月27日
 */
public interface IManagerService extends BaseService {


    /**
     * 描述：根据id获取Manager
     *
     * @param id 管理员id
     * @return
     * @throws Exception
     */
    Manager getManagerById(String id) throws Exception;

}