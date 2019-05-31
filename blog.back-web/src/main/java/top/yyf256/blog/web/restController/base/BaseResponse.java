package top.yyf256.blog.web.restController.base;

import top.yyf256.blog.enums.ResponseEnum;

public class BaseResponse {
    protected String rspCode;
    protected String rspMsg;

    public BaseResponse() {
    }

    public BaseResponse(String rspCode, String rspMsg) {
        this.rspCode = rspCode;
        this.rspMsg = rspMsg;
    }

    public BaseResponse(ResponseEnum response){
        this.rspCode = response.getCode();
        this.rspMsg = response.getDesc();
    }

    public String getRspMsg() {
        return rspMsg;
    }

    public void setRspMsg(String rspMsg) {
        this.rspMsg = rspMsg;
    }

    public void setRspCode(String rspCode) {
        this.rspCode = rspCode;
    }

    public String getRspCode() {
        return rspCode;
    }


    @Override
    public String toString() {
        return "BaseResponse{" +
                "rspCode='" + rspCode + '\'' +
                ", rspMsg='" + rspMsg + '\'' +
                '}';
    }
}
