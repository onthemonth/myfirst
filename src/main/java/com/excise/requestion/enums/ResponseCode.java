package com.excise.requestion.enums;

/**
 * Created by mgq on 2015/12/9.
 */
public enum ResponseCode {

    F400(400,"失败400"),

    F401(401,"失败401"),

    F402(402,"失败402"),

    F403(403,"失败403"),

    F404(404,"失败404");

    ResponseCode(int code,String value){
        this.code=code;
        this.mesage=value;
    }

    private int code;

    private String mesage;

    //根据code查询F400.。。。。。。。。。
    public static ResponseCode getResponseCode(int code){
        ResponseCode[] responseCodes=ResponseCode.values();
        ResponseCode responseCode=null;
        for (ResponseCode c:responseCodes){
            if (c.getCode()==code){
                responseCode=c;
            }
        }
        return responseCode;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMesage() {
        return mesage;
    }

    public void setMesage(String mesage) {
        this.mesage = mesage;
    }

    public int getCode(){
        return this.code;
    }
}
