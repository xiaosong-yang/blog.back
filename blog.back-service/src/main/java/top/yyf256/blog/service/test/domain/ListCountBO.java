package top.yyf256.blog.service.test.domain;

import top.yyf256.blog.service.base.BaseBO;

public class ListCountBO extends BaseBO {
    //入参
    private String searchParam1;
    private String searchParam2;

    //缓存
    private String testCash;

    //回参
    private String totalCount;


    public String getSearchParam1() {
        return searchParam1;
    }

    public void setSearchParam1(String searchParam1) {
        this.searchParam1 = searchParam1;
    }

    public String getSearchParam2() {
        return searchParam2;
    }

    public void setSearchParam2(String searchParam2) {
        this.searchParam2 = searchParam2;
    }

    public String getTestCash() {
        return testCash;
    }

    public void setTestCash(String testCash) {
        this.testCash = testCash;
    }

    public String getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }
}
