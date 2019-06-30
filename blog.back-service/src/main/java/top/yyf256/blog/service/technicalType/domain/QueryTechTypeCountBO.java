package top.yyf256.blog.service.technicalType.domain;

import top.yyf256.blog.service.base.BaseBO;

public class QueryTechTypeCountBO extends BaseBO {
    private String technicalTypeName;

    private String totalCount;

    public String getTechnicalTypeName() {
        return technicalTypeName;
    }

    public void setTechnicalTypeName(String technicalTypeName) {
        this.technicalTypeName = technicalTypeName;
    }

    public String getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }
}
