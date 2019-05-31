package top.yyf256.blog.web.restController.blog.back.list;//package top.yyf256.blog.web.restController.blog.back;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.yyf256.blog.enums.SystemExceptionEnum;
import top.yyf256.blog.service.test.DemoService;
import top.yyf256.blog.service.test.domain.ListBO;
import top.yyf256.blog.util.customException.SystemException;
import top.yyf256.blog.web.restController.blog.back.list.domain.ListResponse;
import top.yyf256.blog.web.restController.blog.back.listCount.domain.ListRequest;
import top.yyf256.util.json.JsonUtil;


@RestController
@RequestMapping("/blog.back")
public class ListRestController {

    @Autowired
    private DemoService demoService;

    @Value("${spring.datasource.url}")
    private String mysqlUrl;

    private Logger logger = LogManager.getLogger(ListRestController.class);


    @RequestMapping("/getList")
    public ListResponse getList(ListRequest request) {
        ListResponse response = new ListResponse();
        try {
            logger.info("获取列表接口请求参数：" + JsonUtil.objectToString(request));
            ListBO bo = new ListBO();
            request2BO(request, bo);
            bo = demoService.getList(bo);
            bo2Response(bo, response);
            logger.info("获取列表接口返回参数：" + JsonUtil.objectToString(response));
        } catch (SystemException e) {
            response.setRspCode(e.getCode());
            response.setRspMsg(e.getDesc());
        } catch (Exception e) {
            response.setRspCode(SystemExceptionEnum.SYSTEM_EXCEPTION.getCode());
            response.setRspMsg(SystemExceptionEnum.SYSTEM_EXCEPTION.getDesc());
        }
        return response;

    }

    public void request2BO(ListRequest request, ListBO bo) {

    }

    public void bo2Response(ListBO bo, ListResponse response) {
        response.setRspMsg(bo.getRspDesc());
        response.setRspCode(bo.getRspCode());
        response.setList(bo.getList());
    }
}
