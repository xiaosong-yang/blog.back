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
                <h1><i class="fa fa-dashboard"></i>小编辑</h1>
            </div>
            <ul class="app-breadcrumb breadcrumb">
                <li class="breadcrumb-item"><i class="fa fa-home fa-lg"></i></li>
                <li class="breadcrumb-item"><a href="#">小编辑</a></li>
            </ul>
        </div>

        <div class="row">
            <div class="col-md-12">
                <div class="tile">
                    <div class="row">
                        <div class="col-lg-12">
                            <form>
                                <div class="form-group">
                                    <label for="merchantId">商户号</label>
                                    <input class="form-control" id="merchantId" type="text" aria-describedby="emailHelp" placeholder="商户号" readonly="" value="">
                                </div>
                                <div class="form-group">
                                    <label for="merchantName">商户名</label>
                                    <input class="form-control" id="merchantName" type="text" aria-describedby="emailHelp" placeholder="商户名" value="">
                                </div>
                                <div class="form-group">
                                    <label for="password">密码</label>
                                    <input class="form-control" id="password" type="password" placeholder="修改密码">
                                </div>
                                <div class="form-group">
                                    <label for="confirmPassword">确认密码</label>
                                    <input class="form-control" id="confirmPassword" type="password" placeholder="确认密码">
                                </div>
                                <div class="form-group">
                                    <label for="stateSelect">商户状态</label>
                                    <div class="tile-body">
                                        <select class="form-control" id="stateSelect">
                                            <optgroup label="状态选择">
                                                <#list chooses as choose>
                                                <option value="${choose.value }">${choose.name }/${choose_index }</option>
                                                </#list>
                                            </optgroup>
                                        </select>
                                        <script>
                                            document.getElementById("stateSelect").value="";
                                        </script>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="tile-footer">
                        <button class="btn btn-primary" type="button" onclick="sumbmitAddMerchant();">提交</button>
                    </div>
                </div>
            </div>
        </div>
    </main>
    <script>
        var f_menu = "f_menu2";
        var s_menu = "s_menu2";

    </script>
<#include "../common_footer_link.ftl" />
</body>
<script>
    $(document).ready(function() {
        $('#stateSelect').select2();
    });

    function sumbmitAddMerchant(){
        var merchantId = $("#merchantId").val();
        var merchantName = $("#merchantName").val();
        var password = $("#password").val();
        var confirmPassword = $("#confirmPassword").val();
        var stateSelect = $("#stateSelect").val();

        $.ajax({
            "url":"/"+projectName+"/merchant/addMerchantSubmit",
            "data":{
                "merchantId":merchantId,
                "merchantName":merchantName,
                "password":password,
                "confirmPassword":confirmPassword,
                "stateSelect":stateSelect
            },
            "type":"POST",
            "success":function(rsp){
                show_warn_dialog(rsp.rspMsg);
            }
        });
    }
</script>
</html>