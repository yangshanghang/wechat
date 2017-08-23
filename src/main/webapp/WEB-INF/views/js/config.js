require.config({
    baseUrl: '/js',
    paths: {
        'jquery': 'lib/jquery/jquery-1.12.3.min',
        'handlebars': 'lib/handlebars-1.0.0',
        'layer1': 'lib/layer/layer',
        'laydate': 'lib/laydate/laydate',
        'pagination': 'lib/pagination/jquery.pagination',
        'jquery.validate': 'lib/validate/jquery.validate.min',
        'jquery.layout': 'lib/layout/jquery.layout-latest',
        'jszip': 'lib/datatable/jszip.min',
        'bootstrap': 'lib/bootstrap/js/bootstrap.min',
        'jquery.serialize': 'lib/jquery/jquery.serialize-object.min',
        'metisMenu': 'lib/metisMenu',
        'contabs': 'lib/contabs.min',
        'pace': 'lib/pace/pace.min',
        'select2': 'lib/select2/select2.min',
        'jquery.nanoscroller': 'lib/jquery/jquery.nanoscroller.min',
        'autoLineNumber': 'lib/auto-line-number',
        'weui': 'lib/jqueryweui/jquery-weui.min'
    },
    shim: {
        'bootstrap': {
            deps: ['jquery']
        },
        'layer1': {
            deps: ['jquery']
        },
        'pagination': {
            deps: ['jquery']
        },
        'laydate': {
            deps: ['jquery']
        },
        'jquery.layout': {
            deps: ['jquery']
        },
        'metisMenu': {
            deps: ['jquery']
        },
        'contabs': {
            deps: ['jquery']
        },
        'select2': {
            deps: ['jquery']
        },
        'autoLineNumber': {
            deps: ['jquery']
        },
        'weui': {
            deps: ['jquery']
        },
        'fastclick': {
            deps: ['jquery']
        }
    },
    waitSeconds: 0
});