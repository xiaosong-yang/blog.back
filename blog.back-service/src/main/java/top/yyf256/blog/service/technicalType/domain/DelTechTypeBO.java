package top.yyf256.blog.service.technicalType.domain;

import top.yyf256.blog.service.base.BaseBO;

public class DelTechTypeBO extends BaseBO {
    private String techTypeName;

    public String getTechTypeName() {
        return techTypeName;
    }

    public void setTechTypeName(String techTypeName) {
        this.techTypeName = techTypeName;
    }
}
