package top.yyf256.blog.service.technicalType.domain;

import top.yyf256.blog.service.base.BaseBO;

public class TechnicalTypeBO extends BaseBO {
    private String typeName;
    private String imgUrl;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
