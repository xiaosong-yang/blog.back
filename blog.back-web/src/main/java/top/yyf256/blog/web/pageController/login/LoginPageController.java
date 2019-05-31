package top.yyf256.blog.web.pageController.login;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import top.yyf256.blog.constant.SystemConstant;
import top.yyf256.blog.service.test.DemoService;
import top.yyf256.blog.web.pageController.login.domain.TestRequest;
import top.yyf256.blog.web.security.SecurityInterceptor;
import top.yyf256.security.annotation.JanusAuth;
import top.yyf256.security.constants.SecurityCommonConstant;
import top.yyf256.security.domain.SecurityBaseBO;
import top.yyf256.security.enums.BackType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class LoginPageController {


    @Autowired
    private SecurityInterceptor securityInterceptor;


    private Logger logger = LogManager.getLogger(LoginPageController.class);


    @RequestMapping(value = "/", method = RequestMethod.GET)
    @JanusAuth(allowRole = {"Super_Auth"}, backType = BackType.PAGE_BACK)
    public ModelAndView index(HttpSession session, TestRequest requestParams) {
        ModelAndView mov = new ModelAndView();
        mov.setViewName("index");
        return mov;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView toLogin(HttpServletRequest request, TestRequest requestParams) {
        SecurityBaseBO loginBack = (SecurityBaseBO) request.getAttribute(SecurityCommonConstant.AUTH_BACK);
        ModelAndView mov = new ModelAndView();
        mov.addObject(SystemConstant.AUTH_FAIL_MSG, loginBack.getRspDesc());
        mov.setViewName("login");
        return mov;
    }


    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public ModelAndView logout(HttpServletRequest request){
        securityInterceptor.logout(request);
        ModelAndView mov = new ModelAndView();
        mov.setViewName("login");
        return mov;
    }


}
