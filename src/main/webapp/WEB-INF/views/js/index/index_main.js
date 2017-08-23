require(['layer1', 'common/util', 'jquery', 'common/validateRules', 'jquery.layout','jquery.nanoscroller'], function (layer, util) {

    init();

    /**
     * 初始化函数集合
     */
    function init() {
        layoutInit();
        initMenu();
        bind();
        calcHeight();
        $(".nano").nanoScroller();
    }

    /**
     * 页面布局初始化
     */
    function layoutInit() {

        $('#container').layout({
            west: {
                size: '120'
            },
            north: {
                spacing_open: 0
            }
        });
    }

    /**
     * 初始化菜单
     */
    function initMenu() {
        // $('#side-menu').metisMenu();
    }

    /**
     * 计算iframe主体高度
     */
    function setHeight() {
        var h = $(window).height();
        $('.J_mainContent').css('height', h - $('.J_mainContent').offset().top - 40 + 'px');
    }
    function calcHeight() {
        setHeight();
        window.onresize = function () {
            setHeight();
            setTimeout(function(){
                $(".nano").nanoScroller();
            },500);

        };
    }

    var el = $('.js-new-info-list');
    var len = el.find('li').length;
    var i = 0;
    var height = el.find('li').height();

    function bind() {
        util.bindEvents([{
            el: '.js-logout',
            event: 'click',
            handler: function () {
                logOut();
            }
        }, {
            el: '.js-tips-close',
            event: 'click',
            handler: function () {
                $(this).closest('.js-tips-box').fadeOut('1000',function(){
                    setHeight();
                });
            }
        }, {
            el: '.js-tips-last',
            event: 'click',
            handler: function () {
                if (i == 0) {
                    i = len - 1;
                } else {
                    i--;
                }
                el.stop().animate({
                    top: -i * height + 'px'
                }, 500);
            }
        }, {
            el: '.js-tips-next',
            event: 'click',
            handler: function () {
                if (i == len - 1) {
                    i = 0;
                } else {
                    i++;
                }
                el.stop().animate({
                    top: -i * height + 'px'
                }, 500);
            }
        },{
            el:'.J_menuItem',
            event:'click',
            handler:function () {
                $('.nav-second-level li a').removeClass('cur');
                $(this).addClass('cur');
                $(this).closest('.list-item').find('p span').addClass('active');
                $(this).closest('.list-item').siblings().find('p span').removeClass('active');

                var address=$(this).attr('href');
                var iframe = '<iframe class="J_iframe" width="100%" height="100%" src="' + address + '" frameborder="0" seamless></iframe>';
                $('.J_mainContent').html('').append(iframe).attr('src', address);

                return false;
            }
        }])
    }

    function logOut() {
        layer.confirm('确定要退出登录吗?', {icon: 3, title: '提示'}, function () {
            location.assign('/admin/logout');
        });
    }
});