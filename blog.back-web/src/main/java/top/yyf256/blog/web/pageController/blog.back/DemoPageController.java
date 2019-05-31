package top.yyf256.blog.web.pageController.blog.back;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import top.yyf256.blog.service.test.DemoService;
import top.yyf256.blog.web.pageController.blog.back.domain.Choose;
import top.yyf256.blog.web.pageController.login.domain.TestRequest;
import top.yyf256.blog.web.security.SecurityInterceptor;
import top.yyf256.security.annotation.JanusAuth;
import top.yyf256.security.enums.BackType;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Controller
public class DemoPageController {

    @Autowired
    private DemoService demoService;

    @Autowired
    private SecurityInterceptor securityInterceptor;


    private Logger logger = LogManager.getLogger(DemoPageController.class);


    @RequestMapping(value = "/showList", method = RequestMethod.GET)
    @JanusAuth(allowRole = {"Super_Auth"}, backType = BackType.PAGE_BACK)
    public ModelAndView index(HttpSession session, TestRequest requestParams) {
        ModelAndView mov = new ModelAndView();
        mov.setViewName("pages/list");
        return mov;
    }

    @RequestMapping(value = "/edit",method = RequestMethod.GET)
    @JanusAuth(allowRole = {"Super_Auth"}, backType = BackType.PAGE_BACK)
    public ModelAndView edit(){
        ModelAndView mov = new ModelAndView();
        List<Choose> chooses = new ArrayList<>();
        Choose choose1 = new Choose();
        choose1.setValue("1");
        choose1.setName("选择一");
        chooses.add(choose1);
        Choose choose2 = new Choose();
        choose2.setValue("2");
        choose2.setName("选择二");
        chooses.add(choose2);
        mov.setViewName("pages/addMin");
        mov.addObject("chooses",chooses);
        return mov;
    }

    @RequestMapping(value = "/edit2",method = RequestMethod.GET)
    @JanusAuth(allowRole = {"Super_Auth"}, backType = BackType.PAGE_BACK)
    public ModelAndView edit2(){
        ModelAndView mov = new ModelAndView();
        List<Choose> chooses = new ArrayList<>();
        Choose choose1 = new Choose();
        choose1.setValue("1");
        choose1.setName("选择一");
        chooses.add(choose1);
        Choose choose2 = new Choose();
        choose2.setValue("2");
        choose2.setName("选择二");
        chooses.add(choose2);
        mov.setViewName("pages/addMax");
        mov.addObject("awardUrl","www.baidu.com");
        mov.addObject("chooses",chooses);
        return mov;
    }


}
