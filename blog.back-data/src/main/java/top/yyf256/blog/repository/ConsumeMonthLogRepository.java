package top.yyf256.blog.repository;

import top.yyf256.blog.entity.ConsumeMonthLog;

public interface ConsumeMonthLogRepository {
    int deleteByPrimaryKey(String timeId);

    int insert(ConsumeMonthLog record);

    int insertSelective(ConsumeMonthLog record);

    ConsumeMonthLog selectByPrimaryKey(String timeId);

    int updateByPrimaryKeySelective(ConsumeMonthLog record);

    int updateByPrimaryKey(ConsumeMonthLog record);
}