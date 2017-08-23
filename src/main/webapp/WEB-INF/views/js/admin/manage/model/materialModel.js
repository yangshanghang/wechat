define(['common/http'], function (http) {
    /**
     *获取资讯列表数据
     * @param options
     */
    function getMaterialList(options) {
        http.httpRequest({
            url:window.__LPSP_WECHAT__.root_url +'admin/material/readlist',
            success: function(data){
                setTimeout(function(){
                    options.callBack(data);
                },800)
            },
            beforeSend: options.beforeSend,
            data: options.data,
            actionErrorConfig: options.actionErrorConfig
        });
    }

    return {
        getMaterialList: getMaterialList
    }
});