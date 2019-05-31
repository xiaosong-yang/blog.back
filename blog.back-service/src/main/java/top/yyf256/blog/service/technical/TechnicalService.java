package top.yyf256.blog.service.technical;

import top.yyf256.blog.service.technical.domain.*;

public interface TechnicalService {

    TechnicalDetailBO selTechnicalType(TechnicalDetailBO bo);

    AddTechnicalDiaryBO addTechnicalDiary(AddTechnicalDiaryBO bo);

    QueryTechnicalListBO queryTechnicalList(QueryTechnicalListBO bo);

    AllTechnicalTypeBO getAllTechnicalType(AllTechnicalTypeBO bo);

    QueryTechnicalCountBO queryTechnicalCount(QueryTechnicalCountBO bo);
}
