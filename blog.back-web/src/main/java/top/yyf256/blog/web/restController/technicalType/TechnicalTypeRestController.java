package top.yyf256.blog.web.restController.technicalType;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.yyf256.blog.enums.ResponseEnum;
import top.yyf256.blog.enums.SystemExceptionEnum;
import top.yyf256.blog.service.technicalType.AddTechTypeService;
import top.yyf256.blog.service.technicalType.DeleteTechTypeService;
import top.yyf256.blog.service.technicalType.QueryTechTypeCountService;
import top.yyf256.blog.service.technicalType.QueryTechTypeListService;
import top.yyf256.blog.service.technicalType.domain.AddTechTypeBO;
import top.yyf256.blog.service.technicalType.domain.DelTechTypeBO;
import top.yyf256.blog.service.technicalType.domain.QueryTechTypeCountBO;
import top.yyf256.blog.service.technicalType.domain.QueryTechTypeListBO;
import top.yyf256.blog.util.customException.SystemException;
import top.yyf256.blog.web.restController.base.BaseResponse;
import top.yyf256.blog.web.restController.technical.TechnicalRestController;
import top.yyf256.blog.web.restController.technicalType.domain.*;
import top.yyf256.security.annotation.JanusAuth;
import top.yyf256.security.enums.BackType;
import top.yyf256.util.json.JsonUtil;

@RestController
@RequestMapping("/technicalType")
public class TechnicalTypeRestController {

    private Logger logger = LogManager.getLogger(TechnicalRestController.class);

    @Autowired
    private QueryTechTypeCountService queryTechnicalCount;

    @Autowired
    private QueryTechTypeListService queryTechTypeListService;

    @Autowired
    private AddTechTypeService addTechTypeService;


    @Autowired
    private DeleteTechTypeService deleteTechTypeService;

    @RequestMapping("/queryCount")
    @JanusAuth(allowRole = {"Super_Auth"}, backType = BackType.PAGE_BACK)
    public QueryTechTypeCountResponse queryTechTypeCount(QueryTechTypeCountRequest request) throws JsonProcessingException {
        QueryTechTypeCountResponse response = new QueryTechTypeCountResponse();
        try {
            logger.info("查询日志种类数量接口请求参数：" + JsonUtil.objectToString(request));
            QueryTechTypeCountBO bo = new QueryTechTypeCountBO();
            BeanUtils.copyProperties(request, bo);
            queryTechnicalCount.queryTechTypeCountService(bo);
            BeanUtils.copyProperties(bo, response);
            response.setRspCode(ResponseEnum.HANDLE_SUCCESS.getCode());
            response.setRspMsg(ResponseEnum.HANDLE_SUCCESS.getDesc());
        } catch (SystemException e) {
            logger.error("系统异常", e);
            response.setRspCode(e.getCode());
            response.setRspMsg(e.getDesc());
        } catch (Exception e) {
            logger.error("系统异常", e);
            response.setRspCode(SystemExceptionEnum.SYSTEM_EXCEPTION.getCode());
            response.setRspMsg(SystemExceptionEnum.SYSTEM_EXCEPTION.getDesc());
        }
        logger.info("查询日志种类数量接口返回参数：" + JsonUtil.objectToString(response));
        return response;
    }


    @RequestMapping("/queryList")
    @JanusAuth(allowRole = {"Super_Auth"}, backType = BackType.PAGE_BACK)
    public QueryTechTypeListResponse queryList(QueryTechTypeListRequest request) throws JsonProcessingException {
        QueryTechTypeListResponse response = new QueryTechTypeListResponse();
        try {
            logger.info("查询日志种类数量接口请求参数：" + JsonUtil.objectToString(request));
            QueryTechTypeListBO bo = new QueryTechTypeListBO();
            BeanUtils.copyProperties(request, bo);
            queryTechTypeListService.queryTechTypeListService(bo);
            BeanUtils.copyProperties(bo, response);
            response.setRspCode(ResponseEnum.HANDLE_SUCCESS.getCode());
            response.setRspMsg(ResponseEnum.HANDLE_SUCCESS.getDesc());
        } catch (SystemException e) {
            logger.error("系统异常", e);
            response.setRspCode(e.getCode());
            response.setRspMsg(e.getDesc());
        } catch (Exception e) {
            logger.error("系统异常", e);
            response.setRspCode(SystemExceptionEnum.SYSTEM_EXCEPTION.getCode());
            response.setRspMsg(SystemExceptionEnum.SYSTEM_EXCEPTION.getDesc());
        }
        logger.info("查询日志种类数量接口返回参数：" + JsonUtil.objectToString(response));
        return response;
    }


    @RequestMapping("/add")
    @JanusAuth(allowRole = {"Super_Auth"}, backType = BackType.PAGE_BACK)
    public BaseResponse add(AddTechTypeRequest request) throws JsonProcessingException {
        QueryTechTypeListResponse response = new QueryTechTypeListResponse();
        try {
            logger.info("新增技术类型接口请求参数：" + JsonUtil.objectToString(request));
            AddTechTypeBO bo = new AddTechTypeBO();
            BeanUtils.copyProperties(request, bo);
            addTechTypeService.addTechType(bo);
            BeanUtils.copyProperties(bo, response);
            response.setRspCode(ResponseEnum.HANDLE_SUCCESS.getCode());
            response.setRspMsg(ResponseEnum.HANDLE_SUCCESS.getDesc());
        } catch (SystemException e) {
            logger.error("系统异常", e);
            response.setRspCode(e.getCode());
            response.setRspMsg(e.getDesc());
        } catch (Exception e) {
            logger.error("系统异常", e);
            response.setRspCode(SystemExceptionEnum.SYSTEM_EXCEPTION.getCode());
            response.setRspMsg(SystemExceptionEnum.SYSTEM_EXCEPTION.getDesc());
        }
        logger.info("新增技术类型接口返回参数：" + JsonUtil.objectToString(response));
        return response;
    }


    @RequestMapping("/del")
    @JanusAuth(allowRole = {"Super_Auth"}, backType = BackType.PAGE_BACK)
    public BaseResponse del(DelTechTypeRequest request) throws JsonProcessingException {
        QueryTechTypeListResponse response = new QueryTechTypeListResponse();
        try {
            logger.info("删除技术类型接口请求参数：" + JsonUtil.objectToString(request));
            DelTechTypeBO bo = new DelTechTypeBO();
            BeanUtils.copyProperties(request, bo);
            deleteTechTypeService.delTechType(bo);
            BeanUtils.copyProperties(bo, response);
            response.setRspCode(ResponseEnum.HANDLE_SUCCESS.getCode());
            response.setRspMsg(ResponseEnum.HANDLE_SUCCESS.getDesc());
        } catch (SystemException e) {
            logger.error("系统异常", e);
            response.setRspCode(e.getCode());
            response.setRspMsg(e.getDesc());
        } catch (Exception e) {
            logger.error("系统异常", e);
            response.setRspCode(SystemExceptionEnum.SYSTEM_EXCEPTION.getCode());
            response.setRspMsg(SystemExceptionEnum.SYSTEM_EXCEPTION.getDesc());
        }
        logger.info("删除技术类型接口返回参数：" + JsonUtil.objectToString(response));
        return response;
    }
}
