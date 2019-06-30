package top.yyf256.blog.service.technical.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import top.yyf256.blog.constant.SystemConstant;
import top.yyf256.blog.dao.TechnicalShareMapper;
import top.yyf256.blog.dao.TechnicalTypeMapper;
import top.yyf256.blog.dao.UploadImgLogTblMapper;
import top.yyf256.blog.entity.TechnicalShare;
import top.yyf256.blog.entity.TechnicalShareWithBLOBs;
import top.yyf256.blog.entity.TechnicalType;
import top.yyf256.blog.entity.UploadImgLogTbl;
import top.yyf256.blog.enums.ImgState;
import top.yyf256.blog.enums.ResponseEnum;
import top.yyf256.blog.enums.SystemExceptionEnum;
import top.yyf256.blog.model.QueryTechnicalListParams;
import top.yyf256.blog.repository.TechnicalShareRepository;
import top.yyf256.blog.repository.TechnicalTypeRepository;
import top.yyf256.blog.service.technical.TechnicalService;
import top.yyf256.blog.service.technical.domain.*;
import top.yyf256.blog.util.customException.SystemException;
import top.yyf256.util.page.PageRefect;
import top.yyf256.util.page.PageResult;
import top.yyf256.util.string.StringUtil;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class TechnicalServiceImpl implements TechnicalService {

    private Logger logger = LogManager.getLogger(TechnicalServiceImpl.class);

    @Autowired
    private TechnicalTypeRepository technicalTypeRepository;

    @Autowired
    private TechnicalShareMapper technicalShareMapper;

    @Autowired
    private TechnicalTypeMapper technicalTypeMapper;

    @Autowired
    private UploadImgLogTblMapper uploadImgLogTblMapper;

    @Autowired
    private TechnicalShareRepository technicalShareRepository;

    /**
     * 概要长度
     */
    private static final int OVER_VIEW_LENGTH = 100;

    private static final String IMG_REGEX = "http://image.public.yyf256.top/.*?\"";

    @Override
    public TechnicalDetailBO selTechnicalType(TechnicalDetailBO bo) {
        List<String> technicalTypes = technicalTypeRepository.getAllTechnicalTypes();
        bo.setAllTechnicalTypes(technicalTypes);
        if (!StringUtil.stringIsBlank(bo.getTechnicalId())) {
            TechnicalShareWithBLOBs technicalShare = technicalShareMapper.selectByPrimaryKey(Integer.parseInt(bo.getTechnicalId()));
            bo.setContent(technicalShare.getContent());
            bo.setTitle(technicalShare.getTitle());
            bo.setThisType(technicalShare.getType());
        }
        bo.setRspCode(ResponseEnum.HANDLE_SUCCESS.getCode());
        bo.setRspDesc(ResponseEnum.HANDLE_SUCCESS.getDesc());
        return bo;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, timeout = 30)
    public AddTechnicalDiaryBO addTechnicalDiary(AddTechnicalDiaryBO bo) {
        addTechnicalBaseCheck(bo);
        Document document = Jsoup.parse(bo.getContent());
        if (document != null) {
            String overview;
            if (document.text().length() > OVER_VIEW_LENGTH) {
                overview = document.text().substring(0, OVER_VIEW_LENGTH).concat(SystemConstant.ELLIPSIS);
            } else {
                overview = document.text();
            }

            //插入或者更新日志
            TechnicalShareWithBLOBs technicalShare = new TechnicalShareWithBLOBs();
            technicalShare.setTitle(bo.getTitle());
            technicalShare.setType(bo.getType());
            technicalShare.setOverview(overview);
            technicalShare.setContent(bo.getContent());
            technicalShare.setFaceUrl(bo.getTechnicalType().getImgUrl());
            if (StringUtil.stringIsBlank(bo.getId())) {
                //新增
                technicalShare.setBrowseCount(0);
                technicalShare.setPraiseCount(0);
                technicalShare.setCommentCount(0);
                technicalShare.setTime(new Date());
                int id = technicalShareMapper.insertSelective(technicalShare);
                bo.setId(id + SystemConstant.EMPTY);
            } else {
                technicalShare.setId(Integer.parseInt(bo.getId()));
                technicalShareMapper.updateByPrimaryKeySelective(technicalShare);
            }

            //将之前的内容之后的图片给置位为失效
            if (bo.getOldContent() != null) {
                Pattern pattern = Pattern.compile(IMG_REGEX);
                Matcher matcher = pattern.matcher(bo.getOldContent());
                while (matcher.find()) {
                    String str = matcher.group();
                    str = str.substring(0, str.length() - 1);
                    updateUploadImgLogTbl(str, ImgState.DROP);
                }
            }


            //将使用到的图片置位为使用中
            Pattern pattern = Pattern.compile(IMG_REGEX);
            Matcher matcher = pattern.matcher(bo.getContent());
            while (matcher.find()) {
                String str = matcher.group();
                str = str.substring(0, str.length() - 1);
                updateUploadImgLogTbl(str, ImgState.USED);
            }
        } else {
            logger.info("解析技术分享日志内容异常，日志内容如下" + bo.getContent());
            throw new SystemException(SystemExceptionEnum.DIARY_CONTNET_EXCEPTION);
        }
        return bo;
    }

    /**
     * 查询技术日志列表
     *
     * @param bo
     * @return
     */
    @Override
    public QueryTechnicalListBO queryTechnicalList(QueryTechnicalListBO bo) {
        QueryTechnicalListParams queryTechnicalListParams = new QueryTechnicalListParams();
        queryTechnicalListParams.setType(bo.getType());
        queryTechnicalListParams.setTitle(bo.getTitle());
        int cur = Integer.parseInt(bo.getCur());
        int size = Integer.parseInt(bo.getSize());
        int begin = (cur - 1) * size;
        if (begin < 0) {
            begin = 0;
        }
        queryTechnicalListParams.setBegin(begin);
        queryTechnicalListParams.setCount(size);
        List<TechnicalShare> technicalShares = technicalShareRepository.selTechnicalList(queryTechnicalListParams);
        bo.setTechnicalShareList(technicalShares);
        return bo;
    }

    @Override
    public AllTechnicalTypeBO getAllTechnicalType(AllTechnicalTypeBO bo) {
        List<String> technicalTypes = technicalTypeRepository.getAllTechnicalTypes();
        bo.setAllTechnicalTypes(technicalTypes);
        return bo;
    }

    @Override
    public QueryTechnicalCountBO queryTechnicalCount(QueryTechnicalCountBO bo) {
        QueryTechnicalListParams queryTechnicalListParams = new QueryTechnicalListParams();
        queryTechnicalListParams.setTitle(bo.getTitle());
        queryTechnicalListParams.setType(bo.getType());
        Integer totalCount = technicalShareRepository.selTechnicalCount(queryTechnicalListParams);
        if (totalCount != null) {
            bo.setTotalCount(totalCount + SystemConstant.EMPTY);
        } else {
            bo.setTotalCount(SystemConstant.ZERO);
        }

        return bo;
    }

    /**
     * 日志上传基本校验
     *
     * @param bo
     */
    private void addTechnicalBaseCheck(AddTechnicalDiaryBO bo) {
        //技术分享日志类型不存在
        TechnicalType technicalType = technicalTypeMapper.selectByPrimaryKey(bo.getType());
        if (technicalType == null) {
            throw new SystemException(SystemExceptionEnum.TECHNICAL_TYPE_NOT_EXIST);
        }
        bo.setTechnicalType(technicalType);

        //待更新日志是否存在
        if (!StringUtil.stringIsBlank(bo.getId())) {
            TechnicalShareWithBLOBs technicalShare = technicalShareMapper.selectByPrimaryKey(Integer.parseInt(bo.getId()));
            if (technicalShare == null) {
                throw new SystemException(SystemExceptionEnum.DIARY_NOT_EXIST);
            }
            bo.setOldContent(technicalShare.getContent());
        }
    }

    /**
     * 更新图片上传
     *
     * @param url
     * @param imgState
     */
    private void updateUploadImgLogTbl(String url, ImgState imgState) {
        UploadImgLogTbl uploadImgLogTbl = new UploadImgLogTbl();
        uploadImgLogTbl.setImgUrl(url);
        uploadImgLogTbl.setState(imgState.getCode());
        uploadImgLogTblMapper.updateByPrimaryKeySelective(uploadImgLogTbl);
    }

}
