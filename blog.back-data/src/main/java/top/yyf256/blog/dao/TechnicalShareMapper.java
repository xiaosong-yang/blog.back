package top.yyf256.blog.dao;

import org.springframework.stereotype.Repository;
import top.yyf256.blog.entity.TechnicalShare;
import top.yyf256.blog.entity.TechnicalShareWithBLOBs;

@Repository
public interface TechnicalShareMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TechnicalShareWithBLOBs record);

    int insertSelective(TechnicalShareWithBLOBs record);

    TechnicalShareWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TechnicalShareWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TechnicalShareWithBLOBs record);

    int updateByPrimaryKey(TechnicalShare record);
}