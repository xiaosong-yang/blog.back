package top.yyf256.blog.enums;

public enum ResponseEnum {
    HANDLE_SUCCESS("SY_RS_1000","处理成功"),
    HANDLE_FAIL("SY_RS_1001","处理失败"),
    LOGIN_FAIL("SY_RES_1002","登录失败，账号或密码错误"),
    LOGIN_CODE_ERROR("SY_RES_1003","验证码有误"),
    PARAMS_ERROR("SY_RES_1004","参数非法"),
    SYS_ERROR("SY_RES_1005","系统异常"),
    LOGIN_CODE_TIME_OUT("SY_RES_1006","验证码超时，请重新获取验证码"),
    UPLOAD_FILE_FAIL("SY_RES_1007","上传图片失败"),
    ;
    private String code;
    private String desc;

    ResponseEnum(String code, String desc) {
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
