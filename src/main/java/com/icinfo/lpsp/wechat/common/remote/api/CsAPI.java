package com.icinfo.lpsp.wechat.common.remote.api;

import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.lpsp.wechat.common.constant.ConfigConstant;
import com.icinfo.lpsp.wechat.common.remote.client.HttpClient;
import com.icinfo.lpsp.wechat.common.util.StringUtils;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述: 监管系统调用接口 .<br>
 *
 * @author YangShangHang
 * @date 2017/5/19
 */
public class CsAPI extends BaseAPI {
    /**
     * 描述：根据手机号判断是否为工商联络员
     *
     * @param tel 手机号
     * @return
     * @throws Exception
     */
    public static boolean isLiaisonMan(String tel) throws Exception {
        HttpUriRequest request = RequestBuilder.post()
                .setConfig(requestConfig)
                .setUri(ConfigConstant.CS_SERVER_URL + "/reg/message/queryPubEppasswordIsExistByTel.json")
                .addParameter("tel", tel)
                .build();
        Map<String, String> requestInfo = new HashMap<>();
        requestInfo.put("url", request.getURI().toString());
        requestInfo.put("params", StringUtils.assemblyString("{tel:", tel, "}"));
        AjaxResult ajaxResult = HttpClient.executeJsonResult(request, requestInfo, AjaxResult.class);
        return (boolean) ajaxResult.getData();
    }


}
