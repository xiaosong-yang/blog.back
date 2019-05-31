package top.yyf256.blog.service.technical.domain;

import top.yyf256.blog.service.base.BaseBO;

import java.util.List;

public class TechnicalDetailBO extends BaseBO {
    /**
     * 该篇技术分享的编号
     */
    private String technicalId;

    /**
     * 所有技术类型
     */
    private List<String> allTechnicalTypes;
    /**
     * 技术分享具体内容（html）
     */
    private String content;
    /**
     * 技术分享的标题
     */
    private String title;
    /**
     * 所属类型
     */
    private String thisType;

    public String getTechnicalId() {
        return technicalId;
    }

    public void setTechnicalId(String technicalId) {
        this.technicalId = technicalId;
    }

    public List<String> getAllTechnicalTypes() {
        return allTechnicalTypes;
    }

    public void setAllTechnicalTypes(List<String> allTechnicalTypes) {
        this.allTechnicalTypes = allTechnicalTypes;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThisType() {
        return thisType;
    }

    public void setThisType(String thisType) {
        this.thisType = thisType;
    }
}
