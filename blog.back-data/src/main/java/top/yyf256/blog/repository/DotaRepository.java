package top.yyf256.blog.repository;

import top.yyf256.blog.entity.Dota;
import top.yyf256.blog.entity.DotaWithBLOBs;

public interface DotaRepository {
    int deleteByPrimaryKey(Integer id);

    int insert(DotaWithBLOBs record);

    int insertSelective(DotaWithBLOBs record);

    DotaWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DotaWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(DotaWithBLOBs record);

    int updateByPrimaryKey(Dota record);
}