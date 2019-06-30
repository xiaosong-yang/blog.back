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
                <li class="breadcrumb-item"><a href="#">技术分享/技术分享新增</a></li>
            </ul>
        </div>

        <div class="row">
            <div class="col-md-12">
                <div class="tile">
                    <div class="row">
                        <div class="col-lg-12">
                            <form>
                                <div class="form-group">
                                    <label for="merchantId">标题</label>
                                    <input class="form-control" id="titleId" type="text" aria-describedby="emailHelp" placeholder="标题" value="${title!}">
                                    <input type="hidden" value="${technicalId!}" id="technicalId">
                                </div>
                                <div class="form-group">
                                    <label for="stateSelect">类型</label>
                                    <div class="tile-body">
                                        <select class="form-control" id="typeSelect">
                                            <optgroup label="类型选择">
                                                <#list allTechnicalTypes as type>
                                                <option value="${type }">${type }</option>
                                                </#list>
                                            </optgroup>
                                        </select>
                                        <script>
                                            document.getElementById("typeSelect").value="${technicalType!}";
                                        </script>
                                    </div>
                                </div>
                                <div id="editor">
                                    ${content!}
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
        var s_menu = "s_menu1_f3";

    </script>
<#include "../common_footer_link.ftl" />
</body>
<script>
    $(document).ready(function() {
        $('#typeSelect').select2();
    });

    var E = window.wangEditor
    var editor = new E('#editor')
    // 或者 var editor = new E( document.getElementById('editor') )
    // editor.customConfig.uploadImgServer = '/upload'  // 上传图片到服务器
    // editor.customConfig.uploadImgShowBase64 = true   // 使用 base64 保存图片
    editor.customConfig.customUploadImg = function (files, insert) {
        // files 是 input 中选中的文件列表
        // insert 是获取图片 url 后，插入到编辑器的方法
        uploadPic("file",files,insert)
        // 上传代码返回结果之后，将图片插入到编辑器中

    }

    editor.customConfig.zIndex = 100 //不配置的话，会出现富文本挡住上面的选择框的问题
    editor.create()
    // editor.txt.html()

    function uploadPic(key,value,insert){
        var formData = new FormData();
        // formData.append('files', $('#file')[0].files[0]);
        formData.append('file', value[0])
        formData.append("type","000")
        $.ajax({
            url: "${Application.projectName}/upload/img",
            type: "POST",
            data: formData,
            /**
             *必须false才会自动加上正确的Content-Type
             */
            contentType: false,
            /**
             * 必须false才会避开jQuery对 formdata 的默认处理
             * XMLHttpRequest会对 formdata 进行正确的处理
             */
            processData: false,
            success: function (data) {
                if (data.rspCode == "SY_RS_1000") {
                    insert(data.imgUrl)
                }else{
                    show_warn_dialog(data.rspMsg)
                }
            },
            error: function () {
                alert("上传失败！");
            }
        });
    }


    function sumbmitAddMerchant(){
        var content = editor.txt.html();
        var title = $("#titleId").val();
        var type = $("#typeSelect").val();
        var id = $("#technicalId").val();


        $.ajax({
            "url":"${Application.projectName}/technical/add",
            "data":{
                "id":id,
                "title":title,
                "type":type,
                "content":content
            },
            "type":"POST",
            "success":function(rsp){
                if (rsp.rspCode == "SY_RS_1000") {
                    show_warn_dialog(rsp.rspMsg)
                    $("#technicalId").val(rsp.id);
                }else{
                    show_warn_dialog(rsp.rspMsg)
                }
            }
        });
    }
</script>
</html>