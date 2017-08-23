define(['common/http'], function (http) {
    /**
     *获取消息列表数据
     * @param options
     */
    function getMessageList(options) {
        http.httpRequest({
            url:'/wechat/message/getlist',
            success:options.callBack,
            beforeSend: options.beforeSend,
            data: options.data,
            actionErrorConfig: options.actionErrorConfig
        });
    }

    return {
        getMessageList: getMessageList
    }
});