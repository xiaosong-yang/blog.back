package top.yyf256.blog.web.restController.upload;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import top.yyf256.blog.service.upload.UploadService;
import top.yyf256.blog.service.upload.domain.UploadBO;
import top.yyf256.blog.web.restController.base.BaseResponse;
import top.yyf256.blog.web.restController.upload.domain.UploadResponse;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/upload")
public class UploadController {

    private Logger logger = LogManager.getLogger(UploadController.class);

    @Autowired
    private UploadService uploadService;

    @RequestMapping("/img")
    public BaseResponse uploadImg(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        UploadResponse uploadResponse = new UploadResponse();
        String type = request.getParameter("type");
        UploadBO uploadBO = new UploadBO();
        uploadBO.setFile(file);
        uploadBO.setType(type);
        uploadBO = uploadService.upload(uploadBO);
        uploadResponse.setRspCode(uploadBO.getRspCode());
        uploadResponse.setRspMsg(uploadBO.getRspDesc());
        uploadResponse.setImgUrl(uploadBO.getReturnUrl());
        return  uploadResponse;
    }
}
