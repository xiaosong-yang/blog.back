package top.yyf256.blog.service.technicalType.domain;

import top.yyf256.blog.service.base.BaseBO;

import java.util.List;

public class QueryTechTypeListBO extends BaseBO {
    private String cur;
    private String size;
    private String technicalTypeName;

    private List<TechnicalTypeRecord> records;

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

    public List<TechnicalTypeRecord> getRecords() {
        return records;
    }

    public void setRecords(List<TechnicalTypeRecord> records) {
        this.records = records;
    }
}
