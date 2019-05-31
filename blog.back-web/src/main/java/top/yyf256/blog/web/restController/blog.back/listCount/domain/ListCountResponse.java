package top.yyf256.blog.web.restController.blog.back.listCount.domain;

import top.yyf256.blog.web.restController.base.BaseResponse;

public class ListCountResponse extends BaseResponse {
    private String totalCount;

    public String getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }
}
