package top.yyf256.blog.service.technicalType.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.yyf256.blog.constant.SystemConstant;
import top.yyf256.blog.enums.ResponseEnum;
import top.yyf256.blog.repository.TechnicalTypeRepository;
import top.yyf256.blog.service.technicalType.QueryTechTypeCountService;
import top.yyf256.blog.service.technicalType.domain.QueryTechTypeCountBO;


@Service
public class QueryTechTypeCountServiceImpl implements QueryTechTypeCountService {

    @Autowired
    private TechnicalTypeRepository technicalTypeRepository;

    @Override
    public QueryTechTypeCountBO queryTechTypeCountService(QueryTechTypeCountBO bo) {

        int totalCount = technicalTypeRepository.getTechnicalCount(bo.getTechnicalTypeName());
        bo.setTotalCount(totalCount+ SystemConstant.EMPTY);
        bo.setRspCode(ResponseEnum.HANDLE_SUCCESS.getCode());
        bo.setRspDesc(ResponseEnum.HANDLE_SUCCESS.getDesc());
        return bo;
    }
}
