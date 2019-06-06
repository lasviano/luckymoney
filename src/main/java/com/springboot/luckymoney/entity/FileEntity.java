package com.springboot.luckymoney.entity;

public class FileEntity {
    private int id;
    private String name;
    private String Appkey;
    private int length;
    private String sourceId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAppkey() {
        return Appkey;
    }

    public void setAppkey(String appkey) {
        Appkey = appkey;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }
}
