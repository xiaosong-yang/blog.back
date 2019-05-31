package top.yyf256.blog.dao;

import top.yyf256.blog.entity.Config;

public interface ConfigMapper {
    int deleteByPrimaryKey(String key);

    int insert(Config record);

    int insertSelective(Config record);

    Config selectByPrimaryKey(String key);

    int updateByPrimaryKeySelective(Config record);

    int updateByPrimaryKey(Config record);
}