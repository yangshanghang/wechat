package com.icinfo.lpsp.wechat.common.remote.api;

import com.icinfo.lpsp.wechat.common.constant.ConfigConstant;
import com.icinfo.lpsp.wechat.common.remote.client.HttpClient;
import com.icinfo.lpsp.wechat.common.remote.response.MmsApiResponse;
import com.icinfo.lpsp.wechat.common.util.StringUtils;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述: 消息系统调用接口 .<br>
 *
 * @author YangShangHang
 * @date 2017/5/19
 */
public class MmsAPI extends BaseAPI {

    /**
     * 获取消息列表
     *
     * @param phone    手机号
     * @param pageNum  分页页码
     * @param pageSize 分页大小
     * @return 消息列表
     * @throws Exception
     */
    public static MmsApiResponse getMessages(String phone, int pageNum, int pageSize) throws Exception {
        HttpUriRequest request = RequestBuilder.get()
                .setConfig(requestConfig)
                .setUri(ConfigConstant.MMS_SERVER_URL + "/api/message/wx_get_list")
                .addParameter("phone", phone)
                .addParameter("pageNum", String.valueOf(pageNum))
                .addParameter("pageSize", String.valueOf(pageSize))
                .build();
        Map<String, String> requestInfo = new HashMap<>();
        requestInfo.put("url", request.getURI().toString());
        requestInfo.put("params", StringUtils.assemblyString("{phone:", phone, ",pageNum:", String.valueOf(pageNum), ",pageSize:", String.valueOf(pageSize), "}"));
        return HttpClient.executeJsonResult(request, requestInfo, MmsApiResponse.class);
    }
}
