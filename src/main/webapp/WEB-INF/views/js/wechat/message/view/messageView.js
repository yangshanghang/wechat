define(['wechat/message/model/messageModel', 'handlebars', 'weui','common/hbsHelper'], function (model, handlebars) {

    var loadData={
        pageNum :2,//内容类型
        pageSize:10,//加载显示条数
        phone:$('#js-phone').val()
    };

    var template = handlebars.compile($('#listTemplate').html());//内容列表模板
    var loading = false;//loading显示标志
    /**
     * 渲染消息信息列表
     */
    function renderMessage() {
      //存储首次加载后的时间
      localStorage.setItem('lastTime',$('.time:last').text());

        if($('#js-hasNextPage').val()=="true"){
            $('.weui-loadmore').show();
            $(document.body).infinite().on("infinite", function() {
                if(loading) return;
                loading = true;
                $('.weui-loadmore').show();
                $('.js-load-fail').addClass('dip-none');
                _getMessageList(loadData);
            });
        }

        if($('body').scrollHeight()>$('body')[0].clientHeight&&$('#js-hasNextPage').val()!="true"){
            $('.js-load-fail').removeClass('dip-none').text('没有数据了！');
        }
    }


    /**
     * 获取素材列表数据并进行渲染
     * @param loadData   分页信息
     */
    function _getMessageList(loadData) {
        model.getMessageList({
            data:$.param(loadData),
            callBack: function (data) {
                if (data.status == 'success') {
                    $('.message-list').append(template(data.data.list));
                    loadData.pageNum++;

                    if(!data.data.hasNextPage){
                        $('.weui-loadmore').hide();
                        $('.js-load-fail').removeClass('dip-none').text('没有数据了！');
                        $(document.body).destroyInfinite();
                    }

                } else {
                    $('.weui-loadmore').hide();
                    $('.js-load-fail').removeClass('dip-none').text('出错啦！');
                }
                loading = false;
            },
            error: function () {
                $('.weui-loadmore').hide();
                $('.js-load-fail').removeClass('dip-none').text('出错啦！');
                loading = false;
            }
        })
    }



    return {
        renderMessage: renderMessage
    }
});
