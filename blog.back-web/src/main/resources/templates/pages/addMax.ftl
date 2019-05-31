<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <#include "../common_header_link.ftl" />
</head>
<body class="app sidebar-mini rtl">
<#include "../common_menu.ftl" />
    <main class="app-content">
        <div class="app-title">
            <div>
                <h1><i class="fa fa-dashboard"></i>大编辑</h1>
            </div>
            <ul class="app-breadcrumb breadcrumb">
                <li class="breadcrumb-item"><i class="fa fa-home fa-lg"></i></li>
                <li class="breadcrumb-item"><a href="#">大编辑</a></li>
            </ul>
        </div>

        <div class="row" id="main_body" xmlns:v-bind="http://www.w3.org/1999/xhtml" xmlns:v-on="http://www.w3.org/1999/xhtml">
            <div class="col-md-12">
                <div class="tile">
                    <div class="row">
                        <div class="col-md-3">
                            <div class="form-group">
                                <label for="merchantId">商户号</label>
                                <input class="form-control" id="merchantId" type="text" aria-describedby="emailHelp"
                                       placeholder="商户号" readonly="readonly" value="">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="form-group">
                                <label for="productId">商品编号</label>
                                <input class="form-control" id="productId" type="text" aria-describedby="emailHelp"
                                       placeholder="商品编号" readonly="readonly" value="">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="form-group">
                                <label for="productName">商品名</label>
                                <input class="form-control" id="productName" type="text" aria-describedby="emailHelp"
                                       placeholder="商品名" value="">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="form-group">
                                <label for="productTitle">标题</label>
                                <input class="form-control" id="productTitle" type="text" aria-describedby="emailHelp" placeholder="标题"
                                       value="">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="form-group">
                                <label for="productStateSelect">商户状态</label>
                                <div class="tile-body">
                                    <select class="form-control" id="productStateSelect">
                                        <optgroup label="状态选择">
                                            <#list chooses as choose>
                                            <option value="${choose.value}">${choose.name}</option>
                                            </#list>
                                        </optgroup>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="form-group">
                                <label for="originPrice">商品原价</label>
                                <input class="form-control" id="originPrice" aria-describedby="emailHelp"
                                       placeholder="商品名" value="">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="form-group">
                                <label for="discount">商品折扣</label>
                                <input class="form-control" id="discount"  aria-describedby="emailHelp"
                                       placeholder="商品名" value="">
                            </div>
                        </div>
                        <div class="col-md-12">
                            <div class="form-group">
                                <label for="mainUrl">中奖弹窗图片(尺寸：250*135&nbsp;&nbsp;大小：50KB以内&nbsp;&nbsp;格式：png,jpg,gif)</label>
                                <div>
                                    <button class="btn btn-primary" id="awardUrl" href="#">上传</button>
                                    <span>
                                <span><a v-bind:href="awardUrl" target="_blank">${awardUrl}</a></span>
                            </span>
                                </div>
                            </div>
                        </div>

                    </div>
                    <div class="tile-footer">
                        <button class="btn btn-primary" type="button" onclick="sumbmitAddProduct();">提交</button>
                    </div>
                </div>
            </div>
        </div>
    </main>
    <script>
        var f_menu = "f_menu2";
        var s_menu = "s_menu3";

    </script>
<#include "../common_footer_link.ftl" />
</body>
<script>
    $(document).ready(function() {
        $('#productStateSelect').select2();
    });

    var thisVue=new Vue({
        el : "#main_body",
        data : {
            awardUrl:"{{ product.awardUrl }}",
        },
        methods:{
            selectIndex:function(url,List){
                for(var i=0;i<List.length;i++){
                    if(List[i]==url){
                        List.splice(i,1);
                        break;
                    }
                }
            },
            delPic:function(url,index) {
                switch (index)
                {
                    case 3:
                        thisVue.selectIndex(url,this.desUrl);
                    case 4:
                        thisVue.selectIndex(url,this.instructionUrlList);
                        break;
                    case 5:
                        thisVue.selectIndex(url,this.consultationUrl);
                }

            }
        }
    });


    layui.use('upload', function () {
        var upload = layui.upload;
        //执行实例
        var uploadInst = upload.render({
            elem: '#awardUrl' //绑定元素
            , url: '/{{ projectName }}/uploadAwardImg' //上传接口
            , done: function (res) {
                if(res.rspCode=="SY1000"){
                    thisVue.awardUrl = res.url;
                }else{
                    show_warn_dialog(res.rspMsg);
                }
            }
            , error: function () {
                show_warn_dialog("上传失败");
            }
        });
    });
</script>
</html>