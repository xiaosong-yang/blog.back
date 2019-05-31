package top.yyf256.blog.dao;

import top.yyf256.blog.entity.Mood;

public interface MoodMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Mood record);

    int insertSelective(Mood record);

    Mood selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Mood record);

    int updateByPrimaryKey(Mood record);
}