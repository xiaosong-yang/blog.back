package top.yyf256.blog.service.test;

import top.yyf256.blog.service.test.domain.ListBO;
import top.yyf256.blog.service.test.domain.ListCountBO;

public interface DemoService {
    public ListCountBO getCount(ListCountBO bo);

    public ListBO getList(ListBO bo);
}
