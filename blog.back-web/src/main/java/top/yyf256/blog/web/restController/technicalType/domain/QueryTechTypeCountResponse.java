package top.yyf256.blog.web.restController.technicalType.domain;

import top.yyf256.blog.web.restController.base.BaseResponse;

public class QueryTechTypeCountResponse extends BaseResponse {
    private String totalCount;

    public String getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }
}
