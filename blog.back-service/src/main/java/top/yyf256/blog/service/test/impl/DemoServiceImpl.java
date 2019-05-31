package top.yyf256.blog.service.test.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.yyf256.blog.enums.ResponseEnum;
import top.yyf256.blog.service.test.DemoService;
import top.yyf256.blog.service.test.domain.ListBO;
import top.yyf256.blog.service.test.domain.ListCountBO;
import top.yyf256.blog.service.test.domain.ListDetailBO;

import java.util.ArrayList;
import java.util.List;

@Service
public class DemoServiceImpl implements DemoService {
//
//    @Autowired
//    private Test1Mapper test1Mapper;
//
//    @Autowired
//    private Test1Repository test1Repository;

    public ListCountBO getCount(ListCountBO bo) {
        bo.setTotalCount("50");
        bo.setRspCode(ResponseEnum.HANDLE_SUCCESS.getCode());
        bo.setRspDesc(ResponseEnum.HANDLE_SUCCESS.getDesc());
        return bo;
    }


    @Override
    public ListBO getList(ListBO bo){
        List<ListDetailBO> list = new ArrayList<>();
        ListDetailBO listDetailBO = new ListDetailBO();
        listDetailBO.setCol1("1");
        listDetailBO.setCol2("2");
        listDetailBO.setCol3("3");
        listDetailBO.setCol4("4");
        list.add(listDetailBO);
        bo.setList(list);
        bo.setRspCode(ResponseEnum.HANDLE_SUCCESS.getCode());
        bo.setRspDesc(ResponseEnum.HANDLE_SUCCESS.getDesc());
        return bo;
    }
}
