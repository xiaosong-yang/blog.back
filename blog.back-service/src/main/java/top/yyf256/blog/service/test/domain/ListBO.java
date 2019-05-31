package top.yyf256.blog.service.test.domain;

import top.yyf256.blog.service.base.BaseBO;

import java.util.List;

public class ListBO extends BaseBO {
    private List<ListDetailBO> list;

    public List<ListDetailBO> getList() {
        return list;
    }

    public void setList(List<ListDetailBO> list) {
        this.list = list;
    }
}
