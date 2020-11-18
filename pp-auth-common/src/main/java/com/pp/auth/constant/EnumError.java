package com.pp.auth.constant;

public enum EnumError {
    //系统错误
    SYSTEM_ERROR("9999");

    private String code;

    private String message;

    private EnumError(String code) {
        // TODO Auto-generated constructor stub
        this.code = code;
    }

    private EnumError(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
