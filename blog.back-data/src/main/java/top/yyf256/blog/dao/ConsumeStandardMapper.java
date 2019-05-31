package top.yyf256.blog.dao;

import top.yyf256.blog.entity.ConsumeStandard;

public interface ConsumeStandardMapper {
    int deleteByPrimaryKey(String timeId);

    int insert(ConsumeStandard record);

    int insertSelective(ConsumeStandard record);

    ConsumeStandard selectByPrimaryKey(String timeId);

    int updateByPrimaryKeySelective(ConsumeStandard record);

    int updateByPrimaryKey(ConsumeStandard record);
}