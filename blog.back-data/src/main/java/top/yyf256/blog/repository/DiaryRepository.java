package top.yyf256.blog.repository;

import top.yyf256.blog.entity.Diary;
import top.yyf256.blog.entity.DiaryWithBLOBs;

public interface DiaryRepository {
    int deleteByPrimaryKey(Integer id);

    int insert(DiaryWithBLOBs record);

    int insertSelective(DiaryWithBLOBs record);

    DiaryWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DiaryWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(DiaryWithBLOBs record);

    int updateByPrimaryKey(Diary record);
}