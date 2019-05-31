package top.yyf256.blog.web.pageController.technicalShare;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import top.yyf256.blog.constant.ResponseConstant;
import top.yyf256.blog.constant.SystemConstant;
import top.yyf256.blog.enums.ResponseEnum;
import top.yyf256.blog.service.technical.TechnicalService;
import top.yyf256.blog.service.technical.domain.AllTechnicalTypeBO;
import top.yyf256.blog.service.technical.domain.TechnicalDetailBO;
import top.yyf256.blog.util.ParamsValidUtil;
import top.yyf256.blog.util.customException.SystemException;
import top.yyf256.blog.web.security.SecurityInterceptor;
import top.yyf256.security.annotation.JanusAuth;
import top.yyf256.security.enums.BackType;
import top.yyf256.util.string.StringUtil;


@Controller
@RequestMapping("/technical")
public class TechnicalController {


    @Autowired
    private SecurityInterceptor securityInterceptor;

    @Autowired
    private TechnicalService technicalService;



    private Logger logger = LogManager.getLogger(TechnicalController.class);


    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    @JanusAuth(allowRole = {"Super_Auth"}, backType = BackType.PAGE_BACK)
    public ModelAndView editTechnical(TechnicalShareRequest request) {
        TechnicalDetailBO bo = new TechnicalDetailBO();
        ModelAndView mov = new ModelAndView();
        mov.setViewName("pages/editTechnical");
        try {
            checkParams(request);
            cover2Bo(request,bo);
            bo = technicalService.selTechnicalType(bo);
            setModel(bo,mov);
        } catch (SystemException e) {
            logger.error("发生系统异常",e);
            bo.setRspCode(e.getCode());
            bo.setRspDesc(e.getDesc());
        } catch (Exception e) {
            logger.error("发生系统异常",e);
            bo.setRspCode(ResponseEnum.SYS_ERROR.getCode());
            bo.setRspDesc(ResponseEnum.SYS_ERROR.getDesc());
        }
        return mov;
    }

    public void checkParams(TechnicalShareRequest request){
        StringBuilder validParams = new StringBuilder();
        if(!StringUtil.stringIsBlank(request.getTechicalId()) && !ParamsValidUtil.isNumber(request.getTechicalId())){
            validParams.append(validParams).append(SystemConstant.COMMA);
        }
        if(!StringUtil.stringIsBlank(validParams.toString())){
            String desc = ResponseEnum.PARAMS_ERROR + SystemConstant.COLON + ParamsValidUtil.removeLastChart(validParams.toString());
            throw new SystemException(ResponseEnum.PARAMS_ERROR.getCode(),desc);
        }
    }

    public void cover2Bo(TechnicalShareRequest request, TechnicalDetailBO bo){
        bo.setTechnicalId(request.getTechicalId());
    }

    public void setModel(TechnicalDetailBO bo,ModelAndView mov){
        mov.addObject(ResponseConstant.TITLE,bo.getTitle());
        mov.addObject(ResponseConstant.TECHNICAL_ID,bo.getTechnicalId());
        mov.addObject(ResponseConstant.TECHNICAL_CONTENT,bo.getContent());
        mov.addObject(ResponseConstant.ALL_TECHNICAL_TYPES,bo.getAllTechnicalTypes());
        mov.addObject(ResponseConstant.TECHNICAL_TYPE,bo.getThisType());
        mov.addObject(ResponseConstant.RSP_CODE,bo.getRspCode());
        mov.addObject(ResponseConstant.RSP_MSG,bo.getRspDesc());
    }

    @RequestMapping(value = "/technicalList", method = RequestMethod.GET)
    @JanusAuth(allowRole = {"Super_Auth"}, backType = BackType.PAGE_BACK)
    public ModelAndView technicalList(){
        ModelAndView mov = new ModelAndView();
        AllTechnicalTypeBO bo = new AllTechnicalTypeBO();
        technicalService.getAllTechnicalType(bo);
        mov.addObject(ResponseConstant.ALL_TECHNICAL_TYPES,bo.getAllTechnicalTypes());
        mov.setViewName("pages/technicalList");
        return mov;
    }

}
