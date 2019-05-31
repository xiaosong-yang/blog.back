package top.yyf256.blog.dao;

import org.springframework.stereotype.Repository;
import top.yyf256.blog.entity.TechnicalType;

@Repository
public interface TechnicalTypeMapper {
    int deleteByPrimaryKey(String name);

    int insert(TechnicalType record);

    int insertSelective(TechnicalType record);

    TechnicalType selectByPrimaryKey(String name);

    int updateByPrimaryKeySelective(TechnicalType record);

    int updateByPrimaryKeyWithBLOBs(TechnicalType record);

    int updateByPrimaryKey(TechnicalType record);
}