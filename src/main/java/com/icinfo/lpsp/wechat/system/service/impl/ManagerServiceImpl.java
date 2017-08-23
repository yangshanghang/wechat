/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.lpsp.wechat.system.service.impl;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.lpsp.wechat.system.mapper.ManagerMapper;
import com.icinfo.lpsp.wechat.system.model.Manager;
import com.icinfo.lpsp.wechat.system.service.IManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述:  LPSP_WECHAT_MANAGER 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年04月27日
 */
@Service
public class ManagerServiceImpl extends MyBatisServiceSupport implements IManagerService {
    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(ManagerServiceImpl.class);

    @Autowired
    private ManagerMapper managerMapper;


    /**
     * 描述：根据id获取Manager
     *
     * @param id 管理员id
     * @return
     * @throws Exception
     */
    @Override
    public Manager getManagerById(String id) throws Exception {
        Manager manager = new Manager();
        manager.setUserId(id);
        List<Manager> managers = managerMapper.select(manager);
        return managers.isEmpty() ? null : managers.get(0);
    }
}