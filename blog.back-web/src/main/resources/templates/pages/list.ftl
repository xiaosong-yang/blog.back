<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>小松博客管理系统</title>
    <#include "../common_header_link.ftl" />
</head>
<body class="app sidebar-mini rtl">
<#include "../common_menu.ftl" />
    <main class="app-content">
        <div class="app-title">
            <div>
                <h1><i class="fa fa-dashboard"></i>列表</h1>
            </div>
            <ul class="app-breadcrumb breadcrumb">
                <li class="breadcrumb-item"><i class="fa fa-home fa-lg"></i></li>
                <li class="breadcrumb-item"><a href="#">列表</a></li>
            </ul>
        </div>

        <div class="row" id="main_body" xmlns:v-on="http://www.w3.org/1999/xhtml" xmlns:v-bind="http://www.w3.org/1999/xhtml">
            <div class="col-md-12">
                <div class="tile">
                    <div class="row" style="margin-bottom: 5px;">
                        <div class="col-md-4">
                            <div class="input-group">
                                <div class="input-group-prepend"><span class="input-group-text">商户号：</span></div>
                                <input class="form-control" id="merchantIdSearch" type="text" placeholder="请输入商户号">
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="input-group">
                                <div class="input-group-prepend"><span class="input-group-text">商户用户名：</span></div>
                                <input class="form-control" id="merchantNameSearch" type="text" placeholder="请输入商户用户名">
                            </div>
                        </div>
                        <button class="btn btn-primary" type="button" onclick="searchList();">搜索</button>
                    </div>

                    <div class="tile-body">
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th>列表一</th>
                                <th>列表二</th>
                                <th>列表三</th>
                                <th>列表四</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr v-for="detail in list">
                                <td>{{ detail.col1 }}</td>
                                <td>{{ detail.col2 }}</td>
                                <td>{{ detail.col3 }}</td>
                                <td>{{ detail.col4 }}</td>
                                <td><a href="#" v-on:click="">删除</a>、
                                    <a v-bind:href="'${Application.projectName}'">修改</a>、
                                    <a v-bind:href="'${Application.projectName}'">增加商品</a></td>
                            </tr>
                            </tbody>
                        </table>
                        <div style="display: inline-block; margin-left: 50%;">
                            <div id="pagination" style="position: relative; right: 50%;"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
    <script>
        var f_menu = "f_menu1";
        var s_menu = "";

    </script>
<#include "../common_footer_link.ftl" />
</body>
<script>
    var vm = new Vue({
        el : "#main_body",
        data : {
            list:[]
        },
        methods:{
            showList: function(searchValue1,searchValue2){
                var data = {
                    "searchValue1":searchValue1,
                    "searchValue2":searchValue2
                }
                $.ajax({
                    "url" : "${Application.projectName}" + "/demo/getListCount",
                    "type" : "POST",
                    "data":data,
                    "success" : function(response) {
                        if (response.rspCode == "SY_RS_1000") {
                            var totalCount = response.totalCount;
                            layui.use('laypage',function() {
                                var laypage = layui.laypage;
                                laypage.render({
                                    elem : 'pagination', //注意，这里的 test1 是 ID，不用加 # 号
                                    count : totalCount,
                                    limit : pageCommonSize,
                                    groups : showCommonPages,
                                    jump : function(obj, first) {
                                        data.cur = obj.curr;
                                        data.size = obj.limit;
                                        $.ajax({
                                            "url" : "${Application.projectName}" + "/demo/getList",
                                            "type" : "POST",
                                            "data" : data,
                                            "success" : function(
                                                list_response) {
                                                if (list_response.rspCode == "SY_RS_1000") {
                                                    vm.list = list_response.list;
                                                } else {
                                                    show_warn_dialog(list_response.rspMsg);
                                                }
                                            }
                                        });
                                    }
                                });
                            });
                        } else {
                            show_warn_dialog(response.rspMsg);
                        }
                    }
                });
            }
        }
    });

    $(function () {
        vm.showList("","")
    })
</script>
</html>