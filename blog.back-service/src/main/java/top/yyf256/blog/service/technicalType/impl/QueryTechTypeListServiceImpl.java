package top.yyf256.blog.service.technicalType.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.yyf256.blog.constant.RequestConstant;
import top.yyf256.blog.constant.SystemConstant;
import top.yyf256.blog.entity.TechnicalType;
import top.yyf256.blog.enums.ResponseEnum;
import top.yyf256.blog.repository.TechnicalTypeRepository;
import top.yyf256.blog.service.technicalType.QueryTechTypeListService;
import top.yyf256.blog.service.technicalType.domain.QueryTechTypeListBO;
import top.yyf256.blog.service.technicalType.domain.TechnicalTypeRecord;
import top.yyf256.blog.util.ParamsValidUtil;
import top.yyf256.blog.util.customException.SystemException;
import top.yyf256.util.string.StringUtil;

import java.util.ArrayList;
import java.util.List;

@Service
public class QueryTechTypeListServiceImpl implements QueryTechTypeListService {

    @Autowired
    private TechnicalTypeRepository technicalTypeRepository;

    @Override
    public QueryTechTypeListBO queryTechTypeListService(QueryTechTypeListBO bo) {
        //参数格式校验
        paramsCheck(bo);

        //业务处理
        handle(bo);

        bo.setRspCode(ResponseEnum.HANDLE_SUCCESS.getCode());
        bo.setRspDesc(ResponseEnum.HANDLE_SUCCESS.getDesc());
        return bo;
    }

    /**
     * 参数校验
     *
     * @param bo
     */
    private void paramsCheck(QueryTechTypeListBO bo) {
        StringBuilder invalidParams = new StringBuilder();
        if (!ParamsValidUtil.isOverZeroInt(bo.getCur())) {
            invalidParams.append(RequestConstant.CUR).append(SystemConstant.COMMA);
        }
        if (!ParamsValidUtil.isOverZeroInt(bo.getSize())) {
            invalidParams.append(RequestConstant.SIZE).append(SystemConstant.COMMA);
        }


        if (!StringUtil.stringIsBlank(invalidParams.toString())) {
            String desc = ResponseEnum.PARAMS_ERROR.getDesc() + SystemConstant.COLON + ParamsValidUtil.removeLastChart(invalidParams.toString());
            throw new SystemException(ResponseEnum.PARAMS_ERROR.getCode(), desc);
        }
    }

    /**
     * 业务处理
     *
     * @param bo
     */
    private void handle(QueryTechTypeListBO bo) {
        //查询
        PageHelper.startPage(Integer.parseInt(bo.getCur()), Integer.parseInt(bo.getSize()));
        List<TechnicalType> technicalTypes = technicalTypeRepository.getByParams(bo.getTechnicalTypeName());

        List<TechnicalTypeRecord> records = coverRecords(technicalTypes);
        bo.setRecords(records);
    }

    private List<TechnicalTypeRecord> coverRecords(List<TechnicalType> technicalTypes){
        List<TechnicalTypeRecord> records = new ArrayList<>();
        for(TechnicalType technicalType:technicalTypes){
            TechnicalTypeRecord record=  new TechnicalTypeRecord();
            record.setTechnicalName(technicalType.getName());
            record.setImgUrl(technicalType.getImgUrl());
            records.add(record);
        }
        return records;
    }


}
