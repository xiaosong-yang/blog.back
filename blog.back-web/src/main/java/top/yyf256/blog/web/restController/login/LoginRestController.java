package top.yyf256.blog.web.restController.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.yyf256.blog.enums.ResponseEnum;
import top.yyf256.blog.web.restController.base.BaseResponse;
import top.yyf256.blog.web.security.SecurityInterceptor;
import top.yyf256.security.annotation.JanusLogin;
import top.yyf256.security.constants.SecurityCommonConstant;
import top.yyf256.security.enums.LoginResult;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@RestController
public class LoginRestController {

    @Autowired
    SecurityInterceptor securityInterceptor;

    @RequestMapping("/loginSubmit")
    @JanusLogin(userNameKey = "username",passwordKey = "password",imgCodeKey = "imgCode")
    public BaseResponse loginSubmit(HttpServletRequest request){
        BaseResponse response = null;
        LoginResult isLoginSuccess = (LoginResult) request.getAttribute(SecurityCommonConstant.LOGIN_SUCCESS_FLAG);
        if(LoginResult.IMG_ERROR.equals(isLoginSuccess)){
            response=new BaseResponse(ResponseEnum.LOGIN_CODE_ERROR);
        }else if(LoginResult.PAGE_TIME_OUT.equals(isLoginSuccess)) {
            response=new BaseResponse(ResponseEnum.LOGIN_CODE_TIME_OUT);
        }else if(LoginResult.LOGIN_FAIL.equals(isLoginSuccess)) {
            response = new BaseResponse(ResponseEnum.LOGIN_FAIL);
        }else{
            response=new BaseResponse(ResponseEnum.HANDLE_SUCCESS);
        }
        return response;
    }



    @RequestMapping("/getCode")
    public void getCode(HttpServletRequest request, HttpServletResponse response){
        BufferedImage img = securityInterceptor.getCode(request,response);

        // 将图像输出到Servlet输出流中。
        ServletOutputStream sos;
        try {
            sos = response.getOutputStream();
            ImageIO.write(img, "jpeg", sos);
            sos.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
