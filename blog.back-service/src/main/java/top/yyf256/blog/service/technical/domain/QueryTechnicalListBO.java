package top.yyf256.blog.service.technical.domain;

import top.yyf256.blog.entity.TechnicalShare;

import java.util.List;

public class QueryTechnicalListBO {
    private String title;
    private String type;
    private String cur;
    private String size;

    private String curPage;
    private String pageSize;

    private String pageCount;
    private List<TechnicalShare>  technicalShareList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCur() {
        return cur;
    }

    public void setCur(String cur) {
        this.cur = cur;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getCurPage() {
        return curPage;
    }

    public void setCurPage(String curPage) {
        this.curPage = curPage;
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

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }
}
