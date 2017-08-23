define(['admin/manage/model/menuModel', 'common/util', 'layer1', 'jquery', 'autoLineNumber'], function (model, util, layer) {

    function init() {
        //绑定事件集合
        _bind();
        //页面首次加载获取JSON
        _pullJson();
    }

    /**
     * 事件集合
     * @private
     */
    function _bind() {
        util.bindEvents([
            {
                el: '.js-pull',
                event: 'click',
                handler: function () {
                    _pullJson();
                }
            },{
                el: '.js-push',
                event: 'click',
                handler: function () {
                    try{
                        $.parseJSON($('.js-area').val());
                        _pushJson();
                    }catch(e){
                        layer.msg("请输入标准JSON格式！", {ltype: 0, time: 2000});
                    }
                }
            }
        ])
    }


    /**
     * 自动生成行号
     * @private
     */
    function _autoLine() {
        $(".js-area").setTextareaCount({
            width: "30px",
            bgColor: "#f3f3f3",
            color: "#333",
            display: "inline-block"
        });
    }
    
    /**
     * 描述：获取JSON
     * @private
     */
    function _pullJson() {
        model.pullJson({
            callBack: function (data) {
                if (data.status === "success" && data.data !== 'error') {
                    layer.closeAll();
                    $('.js-area').val(data.data);
                    _autoLine();
                }else {
                    layer.closeAll();
                    layer.msg('获取失败，请重试');
                }
            },
            error: function () {
                layer.closeAll();
                layer.msg('请求错误');
            }
        });
    }

    /**
     * 描述：提交JSON
     * @private
     */
    function _pushJson() {
        model.pushJson({
            data: {menus:$('.js-area').val()},
            callBack: function (data) {
                layer.closeAll();
                layer.msg('提交成功');
            },
            error: function (jqXHR) {
                layer.closeAll();
                layer.alert('请求错误');
            }

        });
    }

    return {
        init: init
    };
});
