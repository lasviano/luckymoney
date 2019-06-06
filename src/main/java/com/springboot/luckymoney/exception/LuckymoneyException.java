package com.springboot.luckymoney.exception;

public class LuckymoneyException extends RuntimeException {
    private Integer code;

    public LuckymoneyException(Integer code,String message){
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
