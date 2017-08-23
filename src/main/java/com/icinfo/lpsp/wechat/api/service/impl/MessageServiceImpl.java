package com.icinfo.lpsp.wechat.api.service.impl;

import com.icinfo.lpsp.wechat.api.service.IMessageService;
import com.icinfo.lpsp.wechat.common.constant.ConfigConstant;
import com.icinfo.lpsp.wechat.common.remote.response.ApiResponse;
import com.icinfo.lpsp.wechat.common.util.DateUtils;
import com.icinfo.lpsp.wechat.common.util.StringUtils;
import com.icinfo.lpsp.wechat.manage.model.Template;
import com.icinfo.lpsp.wechat.manage.service.ITemplateService;
import com.icinfo.lpsp.wechat.wxsdk.base.BaseResult;
import com.icinfo.lpsp.wechat.wxsdk.message.bean.Data;
import com.icinfo.lpsp.wechat.wxsdk.message.bean.TemplateMessage;
import com.icinfo.lpsp.wechat.wxsdk.template.TemplateMessageManager;
import com.icinfo.lpsp.wechat.wxsdk.token.TokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 描述:消息Service接口实现类.
 */
@Service
public class MessageServiceImpl implements IMessageService {

    @Autowired
    ITemplateService templateService;

    /**
     * 描述：发送模板
     *
     * @param map 数据
     * @return
     * @throws Exception
     */
    @Override
    public ApiResponse sendTemplate(Map<String, Object> map) throws Exception {
        //1.分解map
        Map<String, Object> additionInfo = (Map<String, Object>) map.get("additionInfo");
        if (additionInfo != null) {
            map.putAll(additionInfo);
            map.remove("additionInfo");
        }

        //2.判断业务类型是否存在
        String businessType = String.valueOf(map.get("subType"));
        if (StringUtils.isEmpty(businessType)) {
            return new ApiResponse(ApiResponse.FAIL_CODE, ApiResponse.FAIL_MSG, "业务类型不可为空！");
        }

        //3.根据业务标识获取模板配置
        Template template = templateService.selectByBusinessType(businessType);
        if (template == null) {
            return new ApiResponse(ApiResponse.FAIL_CODE, ApiResponse.FAIL_MSG, "业务类型有误！");
        }

        //4.拼接模板数据
        TemplateMessage templateMessage = join(map, template);

        //5.获取token
        String access_token = TokenManager.getToken(ConfigConstant.APP_ID_LIANLIAN, ConfigConstant.APP_SECRET_LIANLIAN).getAccess_token();

        //6.发送模板数据
        BaseResult baseResult = TemplateMessageManager.sendTemplate(access_token, templateMessage);

        //7.如果发送成功则返回成功信息，否则返回发送失败
        if (baseResult.isSuccess()) {
            return new ApiResponse(ApiResponse.SUCCESS_CODE, ApiResponse.SUCCESS_MSG);
        } else {
            return new ApiResponse(ApiResponse.FAIL_CODE, ApiResponse.FAIL_MSG, StringUtils.assemblyString(baseResult.getErrcode(), "：", baseResult.getErrmsg()));
        }
    }

    /**
     * 描述：拼接模板数据
     *
     * @param map      数据
     * @param template 模板配置
     * @return
     * @throws Exception
     */
    private TemplateMessage join(Map<String, Object> map, Template template) throws Exception {
        //1.按分号拆分配置
        String[] split = StringUtils.split(template.getContent(), ";");

        //2.创建模板数据类型
        Map<String, Data> datas = new HashMap<>();

        //3.循环拆分后得配置，并将其设置到模板数据中
        for (String str : split) {
            String[] data = StringUtils.split(str, ":");
            if ("pushTime".equals(data[1])) {
                datas.put(data[0], new Data(DateUtils.formatDate(new Date(), "yyyy年MM月dd日"), data[2]));
            } else if (map.get(data[1]) != null) {
                datas.put(data[0], new Data(String.valueOf(map.get(data[1])), data[2]));
            }
        }

        //4.创建模板信息
        TemplateMessage templateMessage = new TemplateMessage();

        //5.组装模板数据
        templateMessage.setData(datas);
        templateMessage.setTemplate_id(template.getTemplateId());
        templateMessage.setTouser(String.valueOf(map.get("openId")));
        Object url = map.get("sourceUrl");
        templateMessage.setUrl(url == null ? null : String.valueOf(url));
        return templateMessage;
    }
}
