package top.yyf256.blog.web.restController.blog.back.listCount;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.yyf256.blog.enums.SystemExceptionEnum;
import top.yyf256.blog.service.test.DemoService;
import top.yyf256.blog.service.test.domain.ListCountBO;
import top.yyf256.blog.util.customException.SystemException;
import top.yyf256.blog.web.restController.blog.back.listCount.domain.ListCountResponse;
import top.yyf256.blog.web.restController.blog.back.listCount.domain.ListRequest;
import top.yyf256.util.json.JsonUtil;


@RestController
@RequestMapping("/blog.back")
public class ListCountRestController {

    @Value("${spring.datasource.url}")
    private String mysqlUrl;

    private Logger logger = LogManager.getLogger(ListCountRestController.class);


    @RequestMapping("/getListCount")
    public ListCountResponse getListCount(ListRequest request){
        ListCountResponse response = new ListCountResponse();
        try {
            logger.info("获取数量接口请求参数：" + JsonUtil.objectToString(request));
            ListCountBO bo = new ListCountBO();
            request2BO(request,bo);
//            bo = blog.backService.getCount(bo);
            bo2Response(bo,response);
            logger.info("获取数量接口返回参数：" + JsonUtil.objectToString(response));
        } catch (SystemException e){
            response.setRspCode(e.getCode());
            response.setRspMsg(e.getDesc());
        } catch (Exception e) {
            response.setRspCode(SystemExceptionEnum.SYSTEM_EXCEPTION.getCode());
            response.setRspMsg(SystemExceptionEnum.SYSTEM_EXCEPTION.getDesc());
        }
        return response;

    }

    public void request2BO(ListRequest request, ListCountBO bo){
        bo.setSearchParam1(request.getSearchValue1());
        bo.setSearchParam2(request.getSearchValue2());
    }

    public void bo2Response(ListCountBO bo, ListCountResponse response){
        response.setRspMsg(bo.getRspDesc());
        response.setRspCode(bo.getRspCode());
        response.setTotalCount(bo.getTotalCount());
    }
}
