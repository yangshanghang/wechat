package com.icinfo.lpsp.wechat.common.remote.client;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;

/**
 * String结果返回处理器
 * Created by yushunwei on 2016/8/7.
 */
public class StringResponseHandler {

    private static Logger logger = LoggerFactory.getLogger(StringResponseHandler.class);

    /**
     * 构造函数
     *
     * @return
     */
    public static ResponseHandler createResponseHandler(Map<String, String> requestInfo) {
        return new StringResponseHandlerImpl(requestInfo);
    }

    /**
     * 内部类
     */
    public static class StringResponseHandlerImpl extends BaseResponseHandler  implements ResponseHandler {

        /**
         * 构造函数
         *
         * @param requestInfo 请求内容
         */
        public StringResponseHandlerImpl(Map<String, String> requestInfo) {
            this.requestInfo = requestInfo;
        }

        /**
         * 接口响应处理
         *
         * @param response 接口响应
         * @return String结果
         * @throws IOException
         */
        @Override
        public String handleResponse(HttpResponse response) throws IOException {
            int status = response.getStatusLine().getStatusCode();
            if (status >= 200 && status < 300) {
                HttpEntity entity = response.getEntity();
                return EntityUtils.toString(entity, Consts.UTF_8);
            } else {
                printError("状态码错误:" + status);
                throw new ClientProtocolException("Unexpected response status: " + status);
            }
        }
    }
}
