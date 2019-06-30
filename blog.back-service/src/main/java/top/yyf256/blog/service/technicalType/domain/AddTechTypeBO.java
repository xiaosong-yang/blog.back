package top.yyf256.blog.service.technicalType.domain;

import top.yyf256.blog.service.base.BaseBO;

public class AddTechTypeBO extends BaseBO {
    private String techTypeName;
    private String imgUrl;

    public String getTechTypeName() {
        return techTypeName;
    }

    public void setTechTypeName(String techTypeName) {
        this.techTypeName = techTypeName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
