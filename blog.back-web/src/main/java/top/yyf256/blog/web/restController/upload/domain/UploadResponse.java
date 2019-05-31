package top.yyf256.blog.web.restController.upload.domain;

import top.yyf256.blog.web.restController.base.BaseResponse;

public class UploadResponse extends BaseResponse {
    private String imgUrl;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
