package top.yyf256.blog.web.restController.technical.domain;

import top.yyf256.blog.entity.TechnicalShare;
import top.yyf256.blog.web.restController.base.BaseResponse;

import java.util.List;

public class QueryTechnicalListResponse extends BaseResponse {
    private String curPage;
    private String pageSize;
    private String pageCount;
    private List<TechnicalShare>  technicalShareList;

    public String getCurPage() {
        return curPage;
    }

    public void setCurPage(String curPage) {
        this.curPage = curPage;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getPageCount() {
        return pageCount;
    }

    public void setPageCount(String pageCount) {
        this.pageCount = pageCount;
    }

    public List<TechnicalShare> getTechnicalShareList() {
        return technicalShareList;
    }

    public void setTechnicalShareList(List<TechnicalShare> technicalShareList) {
        this.technicalShareList = technicalShareList;
    }


    @Override
    public String toString() {
        return "QueryTechnicalListResponse{" +
                "curPage='" + curPage + '\'' +
                ", pageSize='" + pageSize + '\'' +
                ", pageCount='" + pageCount + '\'' +
                ", technicalShareList=" + technicalShareList +
                ", rspCode='" + rspCode + '\'' +
                ", rspMsg='" + rspMsg + '\'' +
                '}';
    }
}
