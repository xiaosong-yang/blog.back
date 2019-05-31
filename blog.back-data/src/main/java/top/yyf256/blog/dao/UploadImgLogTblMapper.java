package top.yyf256.blog.dao;

import org.springframework.stereotype.Repository;
import top.yyf256.blog.entity.UploadImgLogTbl;

@Repository
public interface UploadImgLogTblMapper {
    int deleteByPrimaryKey(String imgUrl);

    int insert(UploadImgLogTbl record);

    int insertSelective(UploadImgLogTbl record);

    UploadImgLogTbl selectByPrimaryKey(String imgUrl);

    int updateByPrimaryKeySelective(UploadImgLogTbl record);

    int updateByPrimaryKey(UploadImgLogTbl record);
}