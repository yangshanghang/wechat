/**
 * dom操作
 */
define(['jquery'], function ($) {

    // html代码段集合
    var htmlMap = {
        'loading-large': '<tr class="js-placeholder loading-large loading-pos"><td colspan="2" class="vertical-center"><p><img class="loading-img" src="../../img/loading_32.gif" /></p></td></tr>',
        'empty-data': '<tr class="js-placeholder empty-data loading-pos"><td colspan="2" class="vertical-center"><p><span class="major">唔，未找到任何数据</span> 您还可以看看其它行情哦，或者稍后再试</p></td></tr>',
        'loading-error': '<tr class="js-placeholder loading-error loading-pos"><td colspan="2" class="vertical-center"><p>哎呀，似乎网络开小差了</p></td></tr>'
    };

    /**
     * 加载中占位符
     * @param ele string(selector)
     * @param type string
     */
    function showPlaceholder(ele, type) {
        var overlay = '<div class="overlay"></div>';
        $('body').append(overlay);
        var ele = $(ele);
        var html = htmlMap[type];
        var placeHolder = ele.find('.js-placeholder');
        if (placeHolder.length) {
            placeHolder.remove();
        }
        ele.append(html);
    }

    /**
     * 删除加载占位符
     * @param ele string(selector)
     */
    function removePlaceholder(ele) {
        var ele = $(ele);
        $('.overlay').remove();
        ele.find('.js-placeholder').remove();
    }

    /**
     * 生成下载form表单页面元素
     * info:{
         *      formId:xxx, 表单ID
         *      inputName:yyy, 隐藏域名称
         *      fields:[xxx,yyy,zzz]，下载内容
         *      selectList:[xxx,yyy,zzz]，选中项
         * }
     */
    function generateDldForm(info) {
        var form = '<form id="' + info.formId + '" class="hidden" method="post">',
            key = '',
            value = '';
        $.each(info.selectList, function (i, v) {
            for (var index = 0; index < info.fields.length; index++) {
                key = info.inputName + '[' + i + '].' + info.fields[index];
                value = $(this).data(info.fields[index].toLowerCase());
                if (typeof value == 'undefined') {
                    value = '';
                }
                form += '<input name="' + key + '" value="' + value + '" />';
            }
        });
        form += '</form>';
        return form;
    }


    return {
        showPlaceholder: showPlaceholder,
        removePlaceholder: removePlaceholder,
        generateDldForm: generateDldForm
    }
});