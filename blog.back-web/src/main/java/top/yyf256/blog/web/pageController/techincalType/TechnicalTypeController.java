package top.yyf256.blog.web.pageController.techincalType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import top.yyf256.blog.constant.ResponseConstant;
import top.yyf256.blog.constant.SystemConstant;
import top.yyf256.blog.entity.TechnicalType;
import top.yyf256.blog.enums.ResponseEnum;
import top.yyf256.blog.service.technical.TechnicalService;
import top.yyf256.blog.service.technical.domain.AllTechnicalTypeBO;
import top.yyf256.blog.service.technical.domain.TechnicalDetailBO;
import top.yyf256.blog.service.technicalType.GetTechnicalTypeService;
import top.yyf256.blog.service.technicalType.domain.TechnicalTypeBO;
import top.yyf256.blog.util.ParamsValidUtil;
import top.yyf256.blog.util.customException.SystemException;
import top.yyf256.blog.web.pageController.technicalShare.TechnicalShareRequest;
import top.yyf256.blog.web.security.SecurityInterceptor;
import top.yyf256.security.annotation.JanusAuth;
import top.yyf256.security.enums.BackType;
import top.yyf256.util.string.StringUtil;


@Controller
@RequestMapping("/technicalType")
public class TechnicalTypeController {


    @Autowired
    private GetTechnicalTypeService getAllTechnicalType;


    private Logger logger = LogManager.getLogger(TechnicalTypeController.class);


    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    @JanusAuth(allowRole = {"Super_Auth"}, backType = BackType.PAGE_BACK)
    public ModelAndView editTechnical(TechnicalTypeRequest request) {
        TechnicalTypeBO bo = new TechnicalTypeBO();
        ModelAndView mov = new ModelAndView();
        mov.setViewName("pages/editTechnicalType");
        try {
            cover2Bo(request, bo);
            bo = getAllTechnicalType.getTechnicalTypeService(bo);
            setModel(bo, mov);
        } catch (SystemException e) {
            logger.error("发生系统异常", e);
            bo.setRspCode(e.getCode());
            bo.setRspDesc(e.getDesc());
        } catch (Exception e) {
            logger.error("发生系统异常", e);
            bo.setRspCode(ResponseEnum.SYS_ERROR.getCode());
            bo.setRspDesc(ResponseEnum.SYS_ERROR.getDesc());
        }
        return mov;
    }


    public void cover2Bo(TechnicalTypeRequest request, TechnicalTypeBO bo) {
        bo.setTypeName(request.getTechTypeName());
    }

    public void setModel(TechnicalTypeBO bo, ModelAndView mov) {
        mov.addObject(ResponseConstant.TECHNICAL_TYPE, bo.getTypeName());
        mov.addObject(ResponseConstant.IMG_URL, bo.getImgUrl());
        mov.addObject(ResponseConstant.RSP_CODE, bo.getRspCode());
        mov.addObject(ResponseConstant.RSP_MSG, bo.getRspDesc());
    }


    @RequestMapping(value = "/technicalTypeList", method = RequestMethod.GET)
    @JanusAuth(allowRole = {"Super_Auth"}, backType = BackType.PAGE_BACK)
    public ModelAndView technicalList(){
        ModelAndView mov = new ModelAndView();
        mov.setViewName("pages/technicalTypeList");
        return mov;
    }

}
