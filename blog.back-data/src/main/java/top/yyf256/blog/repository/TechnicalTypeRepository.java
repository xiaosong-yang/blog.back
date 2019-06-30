package top.yyf256.blog.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.yyf256.blog.entity.TechnicalType;

import java.util.List;

@Repository
public interface TechnicalTypeRepository {

    /**
     * 获取所有的类型
     * @return
     */
    List<String> getAllTechnicalTypes();

    int getTechnicalCount(@Param("technicalType")String technicalType);

    List<TechnicalType> getByParams(@Param("technicalType")String technicalType);

}