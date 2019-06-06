package com.springboot.luckymoney.service;

import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectResult;

import java.io.InputStream;

public interface ObjectService {
    PutObjectResult putObject(InputStream in, int length,String Appkey);
    void deleteObject(String key);
}
