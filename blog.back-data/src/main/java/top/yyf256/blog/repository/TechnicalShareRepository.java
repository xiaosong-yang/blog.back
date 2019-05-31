package top.yyf256.blog.repository;

import org.springframework.stereotype.Repository;
import top.yyf256.blog.entity.TechnicalShare;
import top.yyf256.blog.entity.TechnicalShareWithBLOBs;
import top.yyf256.blog.model.QueryTechnicalListParams;
import top.yyf256.util.page.PageSearch;

import java.util.List;
@Repository
public interface TechnicalShareRepository {

    List<TechnicalShare> selTechnicalList(QueryTechnicalListParams pageSearch);

    Integer selTechnicalCount(QueryTechnicalListParams params);
}