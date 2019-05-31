package top.yyf256.blog.dao;

import top.yyf256.blog.entity.ConsumeMonthLog;

public interface ConsumeMonthLogMapper {
    int deleteByPrimaryKey(String timeId);

    int insert(ConsumeMonthLog record);

    int insertSelective(ConsumeMonthLog record);

    ConsumeMonthLog selectByPrimaryKey(String timeId);

    int updateByPrimaryKeySelective(ConsumeMonthLog record);

    int updateByPrimaryKey(ConsumeMonthLog record);
}