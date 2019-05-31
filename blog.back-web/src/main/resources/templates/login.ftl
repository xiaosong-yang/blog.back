<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Main CSS-->
    <link rel="stylesheet" type="text/css" href="${Application.projectName}/stylesheets/main.css">
    <!-- Font-icon css-->
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>${Application.systemName}</title>
  </head>
  <body onkeydown="on_return();">
    <section class="material-half-bg">
      <div class="cover"></div>
    </section>
    <section class="login-content">
      <div class="logo">
        <h1>${Application.systemName}</h1>
      </div>
      <div class="login-box">
        <form class="login-form" action="index.html">
          <h3 class="login-head" style="margin-bottom: 10px;"><i class="fa fa-lg fa-fw fa-user"></i>登录</h3>
          <div class="form-group" style="margin-bottom: 10px;">
            <label class="control-label">用户名</label>
            <input class="form-control" type="text" placeholder="用户名" id="username" autofocus>
          </div>
          <div class="form-group" style="margin-bottom: 10px;">
            <label class="control-label">密码</label>
            <input class="form-control" type="password" placeholder="密码" id="password">
          </div>
          <div class="form-group">
            <label class="control-label">验证码</label>
            <div style="width: 100%;overflow-y: hidden;">
              <input class="form-control" type="text" placeholder="验证码" id="imgCode" id="password" style="width: 50%;float: left;">
              <a href="javascript:changeimg();"><img  src="${Application.projectName}/getCode?time=" style="width: 45%;float:left;margin-left: 3%;height: 35px;" id="code"></a>
            </div>
          </div>
          <a id="toSystemId" href="${Application.projectName}/"></a>
<!--          <div class="form-group">
            <div class="utility">
              <div class="animated-checkbox">
                <label>
                  <input type="checkbox"><span class="label-text">Stay Signed in</span>
                </label>
              </div>
              <p class="semibold-text mb-2"><a href="#" data-toggle="flip">Forgot Password ?</a></p>
            </div>
          </div>-->
          <div class="form-group btn-container">
            <button class="btn btn-primary btn-block"  type="button" onclick="loginSubmit();"><i class="fa fa-sign-in fa-lg fa-fw"></i>登录</button>
          </div>
        </form>
        <form class="forget-form" action="index.html">
          <h3 class="login-head"><i class="fa fa-lg fa-fw fa-lock"></i>Forgot Password ?</h3>
          <div class="form-group">
            <label class="control-label">EMAIL</label>
            <input class="form-control" type="text" placeholder="Email">
          </div>
          <div class="form-group btn-container">
            <button class="btn btn-primary btn-block"><i class="fa fa-unlock fa-lg fa-fw"></i>RESET</button>
          </div>
          <div class="form-group mt-3">
            <p class="semibold-text mb-0"><a href="#" data-toggle="flip"><i class="fa fa-angle-left fa-fw"></i> Back to Login</a></p>
          </div>
        </form>
      </div>
    </section>
    <script src="${Application.projectName}/javascripts/plugins/pace.min.js"></script>
    <script src="${Application.projectName}/javascripts/jquery-3.2.1.min.js"></script>
    <script src="${Application.projectName}/javascripts/vue.min.js"></script>
    <script src="${Application.projectName}/javascripts/popper.min.js"></script>
    <script src="${Application.projectName}/javascripts/bootstrap.min.js"></script>
    <script src="${Application.projectName}/javascripts/common.js"></script>
    <script src="${Application.projectName}/javascripts/main.js"></script>
    <script src="${Application.projectName}/layui/layui.js"></script>
    <script src="${Application.projectName}/javascripts/common.js"></script>
    <script src="${Application.projectName}/javascripts/md5.js"></script>
    <script type="text/javascript">
      // Login Page Flipbox control
      $('.login-content [data-toggle="flip"]').click(function() {
      	$('.login-box').toggleClass('flipped');
      	return false;
      });

      var rspMsg="${authFailMsg!''}";
      $(function(){
          if(rspMsg!=""){
              show_warn_dialog(rspMsg);
          }
      })
    </script>
    <script>
      function on_return() {
        if(window.event.keyCode == 13){
          loginSubmit();
        }
      }
      function loginSubmit(){
          var name = $("#username").val();
          var password = $("#password").val();
          var imgCode = $("#imgCode").val();
          password = $.md5(password+imgCode)
          $.ajax({
              url:"${Application.projectName}/loginSubmit",
              data:{
                  "username":name,
                  "password":password,
                  "imgCode":imgCode
              },
              type:"POST",
              success:function(rsp){
                  if(rsp.rspCode!="SY_RS_1000"){
                      show_warn_dialog(rsp.rspMsg);
                  }else{
                      <#--window.location="${Application.projectName}/";-->
                    $("#toSystemId")[0].click();
                  }
              }
          })
      }

      function changeimg() {
        var myimg = document.getElementById("code");
        now = new Date();
        myimg.src = "${Application.projectName}/getCode?time="+now.getTime();
      }
    </script>
  </body>
</html>