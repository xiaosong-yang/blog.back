package top.yyf256.blog.enums;

public enum  FileType {

    TECHNICAL_SHARE_IMG("000","技术分享图片"),
    ;
    private String code;
    private String desc;

    FileType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
