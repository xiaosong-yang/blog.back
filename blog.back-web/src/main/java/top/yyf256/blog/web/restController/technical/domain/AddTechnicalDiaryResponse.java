package top.yyf256.blog.web.restController.technical.domain;

import top.yyf256.blog.web.restController.base.BaseResponse;

public class AddTechnicalDiaryResponse extends BaseResponse {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "AddTechnicalDiaryResponse{" +
                "id='" + id + '\'' +
                ", rspCode='" + rspCode + '\'' +
                ", rspMsg='" + rspMsg + '\'' +
                '}';
    }
}
