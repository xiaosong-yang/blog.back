package top.yyf256.blog.dao;

import top.yyf256.blog.entity.Book;
import top.yyf256.blog.entity.BookWithBLOBs;

public interface BookMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BookWithBLOBs record);

    int insertSelective(BookWithBLOBs record);

    BookWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BookWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(BookWithBLOBs record);

    int updateByPrimaryKey(Book record);
}