define(['admin/manage/model/materialModel', 'handlebars', 'common/dom', 'common/util', 'pagination', 'common/hbsHelper'], function (model, handlebars, dom, util) {
    var type = 'news';//内容类型
    var template = handlebars.compile($('#listTemplate').html());//内容列表模板
    var pageSize=20;
    /**
     * 渲染素材信息列表
     */
    function renderMaterial() {
        _getMaterialList(type, 0, pageSize);
        _bind();
    }


    /**
     * 获取素材列表数据并进行渲染
     * @param type   栏目ID
     * @param pageNum   分页索引值
     * @param pageSize  每页展示条数
     * @private
     */
    function _getMaterialList(type, pageNum, pageSize) {
        $('#tableList').html('');
        $('.pagination').hide();
        model.getMaterialList({
            actionErrorConfig: {
                dom: '.info-box',
                type: 'loading-error'
            },
            data: {
                type: type,
                offset: pageNum*pageSize,
                count: pageSize
            },
            beforeSend: function () {
                dom.showPlaceholder('.info-box', 'loading-large');
            },
            callBack: function (data) {
                dom.removePlaceholder('.info-box');
                if (data.status == 'success') {
                    if (data.item == 0) {
                        dom.showPlaceholder('.info-box', 'empty-data');
                        return;
                    }
                    $('#tableList').html(template(data.data.materialDtoList));
                    _pagination(data.data, pageNum);
                    $('.pagination').show();
                } else {
                    dom.showPlaceholder('.info-box', 'loading-error');
                }
            }
        })
    }

    /**
     * 分页配置参数
     * @param data
     * @param index
     * @private
     */
    function _pagination(data, index) {
        $('.pagination').pagination(data.total_count, {
            callback: _pageSelectCallback,
            prev_text: '&lt上一页',
            next_text: '下一页&gt',
            num_display_entries: 6,
            num_edge_entries: 2,
            items_per_page:pageSize,
            current_page: index,
            link_to: 'javascript:void(0)',
            ellipse_text: '...'
        });
    }

    /**
     * 点击分页的回调函数
     * @param pageNum   当前点击的那个分页的页数索引值
     * @param jq        装载容器
     * @private
     */
    function _pageSelectCallback(pageNum, jq) {
        $('html,body').animate({scrollTop: 0}, 10);
        _getMaterialList(type, pageNum, pageSize);
    }

    /**
     * 事件绑定
     * @private
     */
    function _bind() {
        util.bindEvents([
            {
                el: '.js-tab',
                event: 'click',
                handler: function () {
                    $(this).children().addClass('active').parent().siblings().children().removeClass('active');
                    type = $(this).data('type');
                    _getMaterialList(type, 0, pageSize);
                }
            }
        ])
    }


    return {
        renderMaterial: renderMaterial
    }
});
