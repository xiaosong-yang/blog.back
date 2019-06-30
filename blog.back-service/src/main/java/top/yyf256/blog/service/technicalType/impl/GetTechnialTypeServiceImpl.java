package top.yyf256.blog.service.technicalType.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.yyf256.blog.dao.TechnicalTypeMapper;
import top.yyf256.blog.entity.TechnicalType;
import top.yyf256.blog.enums.ResponseEnum;
import top.yyf256.blog.service.technicalType.GetTechnicalTypeService;
import top.yyf256.blog.service.technicalType.domain.TechnicalTypeBO;


@Service
public class GetTechnialTypeServiceImpl implements GetTechnicalTypeService {

    @Autowired
    private TechnicalTypeMapper technicalTypeMapper;

    @Override
    public TechnicalTypeBO getTechnicalTypeService(TechnicalTypeBO bo) {
        TechnicalType technicalType = technicalTypeMapper.selectByPrimaryKey(bo.getTypeName());
        if(technicalType!=null){
            bo.setImgUrl(technicalType.getImgUrl());
        }
        bo.setRspCode(ResponseEnum.HANDLE_SUCCESS.getCode());
        bo.setRspDesc(ResponseEnum.HANDLE_SUCCESS.getDesc());
        return bo;
    }
}
