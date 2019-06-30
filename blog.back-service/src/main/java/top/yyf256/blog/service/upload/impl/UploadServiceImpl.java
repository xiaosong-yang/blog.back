package top.yyf256.blog.service.upload.impl;

import net.coobird.thumbnailator.Thumbnails;
import org.apache.ibatis.javassist.bytecode.ByteArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.yyf256.blog.dao.UploadImgLogTblMapper;
import top.yyf256.blog.entity.UploadImgLogTbl;
import top.yyf256.blog.enums.FileType;
import top.yyf256.blog.enums.ImgState;
import top.yyf256.blog.enums.ResponseEnum;
import top.yyf256.blog.service.upload.UploadService;
import top.yyf256.blog.service.upload.domain.UploadBO;
import top.yyf256.blog.util.QiNiuUtil;
import top.yyf256.blog.util.time.DateUtil;

import java.io.*;
import java.util.Date;

@Service
public class UploadServiceImpl implements UploadService {


    private Logger logger = LogManager.getLogger(UploadServiceImpl.class);

    @Autowired
    private UploadImgLogTblMapper uploadImgLogTblMapper;

    @Override
    public UploadBO upload(UploadBO bo) {
        try {
            byte[] fileBytes = bo.getFile().getBytes();

            if(FileType.TECHNICAL_SHARE_IMG.getCode().equals(bo.getType())){
                String url  = QiNiuUtil.uploadImg(fileBytes,"technical");
                bo.setReturnUrl(url);
            }
            if(FileType.TECHNICAL_TYPE_IMG.getCode().equals(bo.getType())){
                InputStream inputStream = new ByteArrayInputStream(bo.getFile().getBytes());
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Thumbnails.of(inputStream).size(199,130).keepAspectRatio(false).toOutputStream(byteArrayOutputStream);
                String url = QiNiuUtil.uploadImg(byteArrayOutputStream.toByteArray(),"technicalType");
                bo.setReturnUrl(url);
            }
            if(bo.getReturnUrl()!=null){
                //插表数据入库
                UploadImgLogTbl uploadImgLogTbl = new UploadImgLogTbl();
                uploadImgLogTbl.setImgUrl(bo.getReturnUrl());
                uploadImgLogTbl.setState(ImgState.UN_USE.getCode());
                uploadImgLogTbl.setUploadDate(DateUtil.getCurrentDate());
                uploadImgLogTbl.setCreateTime(new Date());
                uploadImgLogTblMapper.insertSelective(uploadImgLogTbl);
                bo.setRspCode(ResponseEnum.HANDLE_SUCCESS.getCode());
                bo.setRspDesc(ResponseEnum.HANDLE_SUCCESS.getDesc());
            }else{
                bo.setRspCode(ResponseEnum.UPLOAD_FILE_FAIL.getCode());
                bo.setRspDesc(ResponseEnum.UPLOAD_FILE_FAIL.getDesc());
            }

            return bo;
        } catch (IOException e) {
            logger.error("文件处理异常",e);
            bo.setRspCode(ResponseEnum.HANDLE_FAIL.getCode());
            bo.setRspDesc(ResponseEnum.HANDLE_FAIL.getDesc());
        }
        return bo;
    }
}
