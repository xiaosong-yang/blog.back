package top.yyf256.blog.web.restController.technicalType.domain;

public class QueryTechTypeListRequest {
    private String cur;
    private String size;
    private String technicalTypeName;

    public String getCur() {
        return cur;
    }

    public void setCur(String cur) {
        this.cur = cur;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getTechnicalTypeName() {
        return technicalTypeName;
    }

    public void setTechnicalTypeName(String technicalTypeName) {
        this.technicalTypeName = technicalTypeName;
    }
}
