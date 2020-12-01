package com.pp.common.constant;

public enum EnumError {
    //系统错误
    SYSTEM_ERROR("9999");

    private String code;

    private String message;

    EnumError(String code) {
        this.code = code;
    }

    EnumError(String code, String message) {
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
