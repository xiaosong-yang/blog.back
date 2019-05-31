package top.yyf256.blog.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TechnicalTypeRepository {

    /**
     * 获取所有的类型
     * @return
     */
    List<String> getAllTechnicalTypes();
}