package top.yyf256.blog.repository;

import top.yyf256.blog.entity.Mood;

public interface MoodRepository {
    int deleteByPrimaryKey(Integer id);

    int insert(Mood record);

    int insertSelective(Mood record);

    Mood selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Mood record);

    int updateByPrimaryKey(Mood record);
}