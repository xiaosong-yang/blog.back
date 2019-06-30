package top.yyf256.blog.web.restController.technicalType.domain;

import top.yyf256.blog.service.technicalType.domain.TechnicalTypeRecord;
import top.yyf256.blog.web.restController.base.BaseResponse;

import java.util.List;

public class QueryTechTypeListResponse extends BaseResponse {

    private List<TechnicalTypeRecord> records;


    public List<TechnicalTypeRecord> getRecords() {
        return records;
    }

    public void setRecords(List<TechnicalTypeRecord> records) {
        this.records = records;
    }
}
