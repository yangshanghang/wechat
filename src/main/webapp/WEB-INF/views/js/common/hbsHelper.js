define(['handlebars'], function (handlebars) {
    // 注册通用表格操作菜单
    handlebars.registerHelper('operate', function (v, options) {
        var html;
        if (v == 1) {
            html = '<a href="javascript:void(0);" class="btn btn-primary btn-sm js-add-row">新增</a>' +
                '<a href="javascript:void(0);" class="btn btn-info btn-sm js-edit-row">编辑</a>' +
                '<a href="javascript:void(0);" class="btn btn-danger btn-sm js-delete-row">删除</a>' +
                '<a href="javascript:void(0);" class="btn btn-warning btn-sm js-select-row">查看</a>';
        } else if (v == 2) {
            html = '<a href="javascript:void(0);" class="btn btn-info btn-sm js-edit-row">编辑</a>' +
                '<a href="javascript:void(0);" class="btn btn-danger btn-sm js-delete-row">删除</a>' +
                '<a href="javascript:void(0);" class="btn btn-warning btn-sm js-select-row">查看</a>';
        } else if (v == 3) {
            html = '<a href="javascript:void(0);" class="btn btn-danger btn-sm js-delete-row">删除</a>' +
                '<a href="javascript:void(0);" class="btn btn-warning btn-sm js-select-row">查看</a>';
        } else {
            html = '<a href="javascript:void(0);" class="btn btn-warning btn-sm js-select-row">查看</a>';
        }
        return html;
    });

    //表格序号索引+1
    handlebars.registerHelper("addOne", function (index) {
        //返回+1之后的结果
        return index + 1;
    });

    //注册判断器
    handlebars.registerHelper('ifCond', function (v1, operator, v2, options) {
        switch (operator) {
            case '!=':
                return (v1 != v2) ? options.fn(this) : options.inverse(this);
                break;
            case '==':
                return (v1 == v2) ? options.fn(this) : options.inverse(this);
                break;
            case '===':
                return (v1 === v2) ? options.fn(this) : options.inverse(this);
                break;
            case '<':
                return (v1 < v2) ? options.fn(this) : options.inverse(this);
                break;
            case '<=':
                return (v1 <= v2) ? options.fn(this) : options.inverse(this);
                break;
            case '>':
                return (v1 > v2) ? options.fn(this) : options.inverse(this);
                break;
            case '>=':
                return (v1 >= v2) ? options.fn(this) : options.inverse(this);
                break;
            case '&&':
                return (v1 && v2) ? options.fn(this) : options.inverse(this);
                break;
            case '||':
                return (v1 || v2) ? options.fn(this) : options.inverse(this);
                break;
            case 'length':
                return v1.length === v2 ? options.fn(this) : options.inverse(this);
                break;
            default:
                return options.inverse(this);
                break;
        }
    });

    //注册计算器
    handlebars.registerHelper("math", function (v1, operator, v2) {
        if (operator == "+") {
            return v1 + v2;
        }
        if (operator == "-") {
            return v1 - v2;
        }
        if (operator == "*") {
            return v1 * v2;
        }
        if (operator == "/") {
            return v1 / v2;
        }
        if (operator == "%") {
            return v1 % v2;
        }
    });

    //截取年月日
    handlebars.registerHelper("prettifyDate", function (timestamp) {
        return timestamp ? timestamp.substring(0, 10) : null;
    });

    //区分时间
    handlebars.registerHelper("isShow", function (time, options) {
        time=time.slice(0,10);

        var oDate1 = new Date(localStorage.getItem('lastTime').replace(/年|月/g, "-").replace(/日/g, ""));
        var oDate2 = new Date(time);

        var timeDiffer = Math.ceil((oDate1.getTime() - oDate2.getTime()) / (1000 * 60 * 60 * 24));

        if (timeDiffer >= 1) {
            localStorage.setItem('lastTime',time);
            return options.fn(this);
        }

    });
    //时间截取“年，月，日，时，分”
    handlebars.registerHelper("showYmdhm", function (time, options) {
        return time.slice(0, 16);
    });
    
    //返回年月日
    handlebars.registerHelper("transDate", function (time) {
            time=time.split('-').join('/');
            var oDate=new Date(time);
            var month=oDate.getMonth()+1;
            month=month<10?"0"+month:month;

            return oDate.getFullYear()+'年'+month+'月'+oDate.getDate()+'日';
    });

    //返回时分
    handlebars.registerHelper("transMs", function (time) {
        return time.slice(11,16);
    });

    //判断是否有值
    handlebars.registerHelper("hasurl", function (url,options) {
        var nourl="javascript:void";
        return url?url:nourl;
    });

});

