package top.yyf256.blog.enums;

/**
 * 图片状态
 */
public enum  ImgState {

    UN_USE("00","未使用"),
    USED("01","已使用"),
    DROP("02","弃用"),
    ;


    private String code;
    private String desc;

    ImgState(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
