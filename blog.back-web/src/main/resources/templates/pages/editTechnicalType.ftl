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
            <h1><i class="fa fa-dashboard"></i>技术分享</h1>
        </div>
        <ul class="app-breadcrumb breadcrumb">
            <li class="breadcrumb-item"><i class="fa fa-home fa-lg"></i></li>
            <li class="breadcrumb-item"><a href="#">技术分享/技术分类新增</a></li>
        </ul>
    </div>

    <div class="row">
        <div class="col-md-12">
            <div class="tile">
                <div class="row">
                    <div class="col-lg-12">
                        <form>
                            <div class="form-group">
                                <label for="merchantId">名称</label>
                                <input class="form-control" id="technicalTypeName" type="text" aria-describedby="emailHelp"
                                       placeholder="名称" value="${technicalType!}">
                            </div>
                            <div class="col-md-12">
                                <div class="form-group">
                                    <label for="mainUrl">技术分享种类封面图片(尺寸：190*130&nbsp;&nbsp;尺寸错误的话会自动转换大小尺寸)</label>
                                    <div>
                                        <button type="button"  class="btn btn-primary" id="technicalTypeUploadBtn" href="#">上传</button>
                                        <span>
                                <span><a href="${imgUrl!}" target="_blank" id="imgUrl">${imgUrl!}</a></span>
                            </span>
                                    </div>
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
        var f_menu = "f_menu3";
        var s_menu = "s_menu3_f3";

    </script>
<#include "../common_footer_link.ftl" />
</body>
<script>

    $(function () {
        uploadInst("technicalTypeUploadBtn","sss");
    })

    <#--function uploadInst(id,url){-->
        <#--$("#"+id).after("<input type='file' style='display: none;' id='flie_"+id+"'>");-->
        <#--$("#"+id).click(function () {-->
           <#--$("#file_"+id).trigger("click");-->
        <#--});-->
        <#--$("file_"+id).change(function () {-->
            <#--var formData = new FormData();-->
            <#--formData.append('files', $("file_"+id)[0].files[0]);-->
            <#--formData.append("type","001")-->
            <#--$.ajax({-->
                <#--url: "${Application.projectName}/upload/img",-->
                <#--type: "POST",-->
                <#--data: formData,-->
                <#--/**-->
                 <#--*必须false才会自动加上正确的Content-Type-->
                 <#--*/-->
                <#--contentType: false,-->
                <#--/**-->
                 <#--* 必须false才会避开jQuery对 formdata 的默认处理-->
                 <#--* XMLHttpRequest会对 formdata 进行正确的处理-->
                 <#--*/-->
                <#--processData: false,-->
                <#--success: function (data) {-->
                    <#--if (data.rspCode == "SY_RS_1000") {-->
                        <#--insert(data.imgUrl)-->
                    <#--}else{-->
                        <#--show_warn_dialog(data.rspMsg)-->
                    <#--}-->
                <#--},-->
                <#--error: function () {-->
                    <#--alert("上传失败！");-->
                <#--}-->
            <#--});-->
        <#--})-->
    <#--}-->

    layui.use('upload', function () {
        var upload = layui.upload;
        //执行实例
        var uploadInst = upload.render({
            elem: '#technicalTypeUploadBtn' //绑定元素
            ,url: '${Application.projectName}/upload/img' //上传接口
            ,data: {
                "type":"001"
            }
            ,done: function (res) {
                if(res.rspCode=="SY_RS_1000"){
                    $("#imgUrl").attr("href",res.imgUrl);
                    $("#imgUrl").text(res.imgUrl);
                }else{
                    show_warn_dialog(res.rspMsg);
                }
            }
            , error: function () {
                show_warn_dialog("上传失败");
            }
        });
    });


    function sumbmitAddMerchant() {
        var technicalTypeName = $("#technicalTypeName").val();
        var imgUrl = $("#imgUrl").text();



        $.ajax({
            "url": "${Application.projectName}/technicalType/add",
            "data": {
                "techTypeName": technicalTypeName,
                "imgUrl": imgUrl
            },
            "type": "POST",
            "success": function (rsp) {
                if (rsp.rspCode == "SY_RS_1000") {
                    show_warn_dialog(rsp.rspMsg)
                } else {
                    show_warn_dialog(rsp.rspMsg)
                }
            }
        });
    }
</script>
</html>