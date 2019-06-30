package top.yyf256.blog.service.technicalType.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.yyf256.blog.dao.TechnicalTypeMapper;
import top.yyf256.blog.entity.TechnicalType;
import top.yyf256.blog.service.technicalType.AddTechTypeService;
import top.yyf256.blog.service.technicalType.domain.AddTechTypeBO;

import java.util.Date;

@Service
public class AddTechTypeServiceImpl implements AddTechTypeService {

    @Autowired
    TechnicalTypeMapper technicalTypeMapper;

    @Override
    public AddTechTypeBO addTechType(AddTechTypeBO bo) {
        TechnicalType technicalType = technicalTypeMapper.selectByPrimaryKey(bo.getTechTypeName());
        if(technicalType==null){
            technicalType = new TechnicalType();
            technicalType.setName(bo.getTechTypeName());
            technicalType.setImgUrl(bo.getImgUrl());
            technicalType.setNowCount(0);
            technicalType.setCreateTime(new Date());
            technicalTypeMapper.insert(technicalType);
        }else{
            technicalType.setImgUrl(bo.getImgUrl());
            technicalTypeMapper.updateByPrimaryKeySelective(technicalType);
        }
        return null;
    }
}
