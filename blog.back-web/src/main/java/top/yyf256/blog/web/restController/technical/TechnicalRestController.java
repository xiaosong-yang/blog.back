package top.yyf256.blog.web.restController.technical;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.yyf256.blog.constant.RequestConstant;
import top.yyf256.blog.constant.SystemConstant;
import top.yyf256.blog.enums.ResponseEnum;
import top.yyf256.blog.enums.SystemExceptionEnum;
import top.yyf256.blog.service.technical.TechnicalService;
import top.yyf256.blog.service.technical.domain.AddTechnicalDiaryBO;
import top.yyf256.blog.service.technical.domain.QueryTechnicalCountBO;
import top.yyf256.blog.service.technical.domain.QueryTechnicalListBO;
import top.yyf256.blog.util.ParamsValidUtil;
import top.yyf256.blog.util.customException.SystemException;
import top.yyf256.blog.web.restController.technical.domain.*;
import top.yyf256.security.annotation.JanusAuth;
import top.yyf256.security.enums.BackType;
import top.yyf256.util.string.StringUtil;

@RestController
@RequestMapping("/technical")
public class TechnicalRestController {

    @Autowired
    private TechnicalService technicalService;

    private Logger logger = LogManager.getLogger(TechnicalRestController.class);

    @RequestMapping("/add")
    @JanusAuth(allowRole = {"Super_Auth"}, backType = BackType.PAGE_BACK)
    public AddTechnicalDiaryResponse addTechnicalDiary(AddTechnicalDiaryRequest request) {
        AddTechnicalDiaryResponse response = new AddTechnicalDiaryResponse();
        try {
            logger.info("技术日志上传接口请求参数：" + request.toString());
            AddTechnicalDiaryBO bo = new AddTechnicalDiaryBO();
            checkAddTechnicalDiaryParams(request);
            BeanUtils.copyProperties(request, bo);
            technicalService.addTechnicalDiary(bo);
            BeanUtils.copyProperties(bo, response);
            response.setRspCode(ResponseEnum.HANDLE_SUCCESS.getCode());
            response.setRspMsg(ResponseEnum.HANDLE_SUCCESS.getDesc());
        } catch (SystemException e) {
            logger.error("系统异常",e);
            response.setRspCode(e.getCode());
            response.setRspMsg(e.getDesc());
        } catch (Exception e) {
            logger.error("系统异常",e);
            response.setRspCode(SystemExceptionEnum.SYSTEM_EXCEPTION.getCode());
            response.setRspMsg(SystemExceptionEnum.SYSTEM_EXCEPTION.getDesc());
        }
        logger.info("技术日志上传接口返回参数：" + response.toString());
        return response;
    }


    public void checkAddTechnicalDiaryParams(AddTechnicalDiaryRequest request) {
        StringBuilder invalidParams = new StringBuilder();
        if (!ParamsValidUtil.nullOrLessThanMaxLength(request.getId(), 11)) {
            invalidParams.append(RequestConstant.ID).append(SystemConstant.COMMA);
        }
        if (!StringUtil.stringIsBlank(request.getId()) && !ParamsValidUtil.isNumber(request.getId())) {
            //id不为空，且不是全为数字则非法
            invalidParams.append(RequestConstant.ID).append(SystemConstant.COMMA);
        }
        if (!ParamsValidUtil.notNullAndLessThanMaxLength(request.getTitle(), 50)) {
            invalidParams.append(RequestConstant.TITLE).append(SystemConstant.COMMA);
        }
        if (!ParamsValidUtil.notNullAndLessThanMaxLength(request.getType(), 50)) {
            invalidParams.append(RequestConstant.TYPE).append(SystemConstant.COMMA);
        }
        if (StringUtil.stringIsBlank(request.getContent())) {
            invalidParams.append(RequestConstant.CONTENT).append(SystemConstant.COMMA);
        }
        if (!StringUtil.stringIsBlank(invalidParams.toString())) {
            String desc = ResponseEnum.PARAMS_ERROR.getDesc() + SystemConstant.COLON + ParamsValidUtil.removeLastChart(invalidParams.toString());
            throw new SystemException(ResponseEnum.PARAMS_ERROR.getCode(), desc);
        }
    }



    @RequestMapping("/queryList")
    @JanusAuth(allowRole = {"Super_Auth"}, backType = BackType.PAGE_BACK)
    public QueryTechnicalListResponse queryList(QueryTechnicalListRequest request){
        QueryTechnicalListResponse response = new QueryTechnicalListResponse();
        try {
            logger.info("查询日志接口请求参数：" + request.toString());
            QueryTechnicalListBO bo = new QueryTechnicalListBO();
            BeanUtils.copyProperties(request, bo);
            technicalService.queryTechnicalList(bo);
            BeanUtils.copyProperties(bo, response);
            response.setRspCode(ResponseEnum.HANDLE_SUCCESS.getCode());
            response.setRspMsg(ResponseEnum.HANDLE_SUCCESS.getDesc());
        } catch (SystemException e) {
            logger.error("系统异常",e);
            response.setRspCode(e.getCode());
            response.setRspMsg(e.getDesc());
        } catch (Exception e) {
            logger.error("系统异常",e);
            response.setRspCode(SystemExceptionEnum.SYSTEM_EXCEPTION.getCode());
            response.setRspMsg(SystemExceptionEnum.SYSTEM_EXCEPTION.getDesc());
        }
        logger.info("查询日志接口返回参数：" + response.toString());
        return response;
    }



    @RequestMapping("/queryCount")
    @JanusAuth(allowRole = {"Super_Auth"}, backType = BackType.PAGE_BACK)
    public QueryTechnicalCountResponse queryCount(QueryTechnicalCountRequest request){
        QueryTechnicalCountResponse response = new QueryTechnicalCountResponse();
        try {
            logger.info("查询日志数量接口请求参数：" + request.toString());
            QueryTechnicalCountBO bo = new QueryTechnicalCountBO();
            BeanUtils.copyProperties(request, bo);
            technicalService.queryTechnicalCount(bo);
            BeanUtils.copyProperties(bo, response);
            response.setRspCode(ResponseEnum.HANDLE_SUCCESS.getCode());
            response.setRspMsg(ResponseEnum.HANDLE_SUCCESS.getDesc());
        } catch (SystemException e) {
            logger.error("系统异常",e);
            response.setRspCode(e.getCode());
            response.setRspMsg(e.getDesc());
        } catch (Exception e) {
            logger.error("系统异常",e);
            response.setRspCode(SystemExceptionEnum.SYSTEM_EXCEPTION.getCode());
            response.setRspMsg(SystemExceptionEnum.SYSTEM_EXCEPTION.getDesc());
        }
        logger.info("查询日志数量接口返回参数：" + response.toString());
        return response;
    }
}
