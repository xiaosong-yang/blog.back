package top.yyf256.blog.dao;

import top.yyf256.blog.entity.ConsumeLog;

public interface ConsumeLogMapper {
    int deleteByPrimaryKey(String timeId);

    int insert(ConsumeLog record);

    int insertSelective(ConsumeLog record);

    ConsumeLog selectByPrimaryKey(String timeId);

    int updateByPrimaryKeySelective(ConsumeLog record);

    int updateByPrimaryKey(ConsumeLog record);
}