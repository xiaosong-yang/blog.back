package top.yyf256.blog.service.technical.domain;

import top.yyf256.blog.entity.TechnicalType;

public class AddTechnicalDiaryBO {
    private String id;
    private String title;
    private String type;
    private String content;


    private TechnicalType technicalType;
    private String oldContent;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public TechnicalType getTechnicalType() {
        return technicalType;
    }

    public void setTechnicalType(TechnicalType technicalType) {
        this.technicalType = technicalType;
    }

    public String getOldContent() {
        return oldContent;
    }

    public void setOldContent(String oldContent) {
        this.oldContent = oldContent;
    }
}
