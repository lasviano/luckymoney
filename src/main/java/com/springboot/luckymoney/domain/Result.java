package com.springboot.luckymoney.domain;

public class Result {
    private Integer code;
    private String msg;
    private Luckymoney data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Luckymoney getData() {
        return data;
    }

    public void setData(Luckymoney data) {
        this.data = data;
    }
}
