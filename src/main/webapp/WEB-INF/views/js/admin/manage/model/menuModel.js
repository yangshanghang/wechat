define(['common/http'], function (http) {

    /**
     * 描述：请求json
     * @param options
     */
    function pullJson(options) {
        http.httpRequest({
            url: window.__LPSP_WECHAT__.root_url + "admin/menu/readlist",
            type: 'GET',
            success: function (data) {
                options.callBack(data);
            },
            
            error: options.error
        });
    }

    /**
     * 描述：提交json
     * @param options
     */
    function pushJson(options) {
        http.httpRequest({
            url: window.__LPSP_WECHAT__.root_url + "admin/menu/add",
            type: 'post',
            data:options.data,
            success: function (data) {
                options.callBack(data);
            },

            error: options.error
        });
    }

    return {
        pullJson: pullJson,
        pushJson: pushJson
    }
});