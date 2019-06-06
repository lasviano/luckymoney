package com.springboot.luckymoney.dao;

public class FileBean {
    private int fileid;
    private String name;
    private int length;    // 文件大小
    private String createTime;// 上传时间，格式：yyyy-MM-dd hh:mm:ss

    public long getFileid() {
        return fileid;
    }

    public void setFileid(int fileid) {
        this.fileid = fileid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
