package top.yyf256.blog.enums;

public enum SystemExceptionEnum {
    SYSTEM_EXCEPTION("SY_EX_1000","系统异常"),
    TECHNICAL_TYPE_NOT_EXIST("SY_RES_1001","技术分享日志类型不存在"),
    DIARY_NOT_EXIST("SY_RES_1001","更新日志不存在"),
    DIARY_CONTNET_EXCEPTION("SY_RES_1001","日志内容异常"),
    ;
    private String code;
    private String desc;

    SystemExceptionEnum(String code, String desc) {
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
