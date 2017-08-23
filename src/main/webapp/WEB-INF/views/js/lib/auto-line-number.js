;(function ($) {
    var AutoRowsNumbers = function (element, config) {
        this.$pull = $('.btn-pull');
        this.$element = $(element);
        this.$group = $('<div/>', {'class': "textarea-group"});
        this.$ol = $('<div/>', {'class': 'textarea-rows'});
        this.$group.css({
            "width": '100%',
            "display": config.display
        });

        this.$height = this.$element.height();

        this.$ol.css({
            "color": config.color,
            "width": config.width,
            "height": this.$height,
            "font-size": this.$element.css("font-size"),
            "line-height": this.$element.css("line-height"),
            "position": "absolute",
            "overflow": "hidden",
            "margin": 0,
            "padding": 0,
            "text-align": "center",
            "font-family": "仿宋",
            'border': '1px solid #dfe6eb',
            'background-color': '#f3f7f9'
        });

        this.$element.css({
            "white-space": "pre",
            "resize": "none",
            "padding-left": (parseInt(config.width) - parseInt(this.$element.css("border-left-width"))) + 5 + 'px',
            "width": '100%'
        });

    };

    AutoRowsNumbers.prototype = {
        constructor: AutoRowsNumbers,
        init: function () {
            var that = this;
            var resizeTimer = null;
            that.$element.wrap(that.$group);
            that.$ol.insertBefore(that.$element);
            that.$element.on('keydown focus', {that: that}, that.inputText);
            that.$pull.on('click', {that: that}, that.inputText);
            that.$element.on('scroll', {that: that}, that.syncScroll);
            that.inputText({data: {that: that}});
            $(window).on('resize', {that: that,resizeTimer:resizeTimer}, that.autoHeight)
        },

        autoHeight: function (event) {
            var that = event.data.that;

            if (event.data.resizeTimer) {
                clearTimeout(event.data.resizeTimer);
            }
            event.data.resizeTimer = setTimeout(function () {
                that.$height = that.$element.height();
                that.$ol.css({
                    "height": that.$height
                });
            }, 30);

        },

        inputText: function (event) {
            var that = event.data.that;
            setTimeout(function () {
                var value = that.$element.val();
                value.match(/\n/g) ? that.updateLine(value.match(/\n/g).length + 1) : that.updateLine(1);
                that.syncScroll({data: {that: that}});
            },0);
        },


        updateLine: function (count) {
            var that = this;
            that.$element;
            that.$ol.html('');

            for (var i = 1; i <= count; i++) {
                that.$ol.append("<div>" + i + "</div>");
            }
        },

        syncScroll: function (event) {
            var that = event.data.that;
            that.$ol.children().eq(0).css("margin-top", -(that.$element.scrollTop()) + "px");
        }
    }

    $.fn.setTextareaCount = function (option) {
        var config = {};
        var option = arguments[0] ? arguments[0] : {};
        config.color = option.color ? option.color : "#FFF";
        config.width = option.width ? option.width : "30px";
        config.bgColor = option.bgColor ? option.bgColor : "#999";
        config.display = option.display ? option.display : "block";

        return this.each(function () {
            var $this = $(this),
                data = $this.data('autoRowsNumbers');

            if (!data) {
                $this.data('autoRowsNumbers', (data = new AutoRowsNumbers($this, config)));
            }

            if (typeof option === 'string') {
                return false;
            } else {
                data.init();
            }
        });
    }
})(jQuery);
