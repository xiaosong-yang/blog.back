package top.yyf256.blog.web.restController.technicalType.domain;

public class AddTechTypeRequest {

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
