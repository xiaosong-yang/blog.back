package top.yyf256.blog.service.upload.domain;

import org.springframework.web.multipart.MultipartFile;
import top.yyf256.blog.service.base.BaseBO;

public class UploadBO extends BaseBO {
    private MultipartFile file;
    private String type;

    private String returnUrl;


    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }
}
