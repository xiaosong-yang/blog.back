package top.yyf256.blog.web.restController.blog.back.list.domain;

import top.yyf256.blog.service.test.domain.ListDetailBO;
import top.yyf256.blog.web.restController.base.BaseResponse;

import java.util.List;

public class ListResponse extends BaseResponse {
    private List<ListDetailBO> list;


    public List<ListDetailBO> getList() {
        return list;
    }

    public void setList(List<ListDetailBO> list) {
        this.list = list;
    }
}
