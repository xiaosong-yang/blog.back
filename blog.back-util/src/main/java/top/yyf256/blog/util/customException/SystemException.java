package top.yyf256.blog.util.customException;

import top.yyf256.blog.enums.SystemExceptionEnum;

public class SystemException extends RuntimeException{

    private String code;
    private String desc;

    public SystemException(SystemExceptionEnum exception){
        super(exception.getDesc());
        this.code = exception.getCode();
        this.desc = exception.getDesc();
    }

    public SystemException(String code,String desc){
        super(desc);
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
