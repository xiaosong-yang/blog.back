function show_warn_dialog(msg) {
    top.layui.use('layer', function() {
        var layer = layui.layer;
        layer.open({
            title: '提示'
            ,content: '<div style="display: inline-block; margin-left: 50%;"><div id="pagination" style="position: relative; right: 50%;">'+msg+'</div></div>'
        });
    });
}

//分页单页数量
var pageCommonSize=10;
//分页插件显示的页数
var showCommonPages=10;