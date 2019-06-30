package top.yyf256.blog.service.technicalType.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.yyf256.blog.dao.TechnicalTypeMapper;
import top.yyf256.blog.service.technicalType.DeleteTechTypeService;
import top.yyf256.blog.service.technicalType.domain.DelTechTypeBO;

@Service
public class DelTechTypeServiceImpl implements DeleteTechTypeService {
    @Autowired
    private TechnicalTypeMapper technicalTypeMapper;
    @Override
    public DelTechTypeBO delTechType(DelTechTypeBO bo) {
        technicalTypeMapper.deleteByPrimaryKey(bo.getTechTypeName());
        return bo;
    }
}
