package com.springboot.luckymoney.service.impl;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.model.GetObjectRequest;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import com.springboot.luckymoney.service.ObjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.InputStream;

@Service
public class ObjectServiceImpl implements ObjectService {
    private static final Logger logger = LoggerFactory.getLogger(ObjectServiceImpl.class);

    private COSClient cosClient;

    @Value("${fileBucketName}")
    private String bucketName;

    @PostConstruct
    public void init(){
        // 1 初始化用户身份信息（secretId, secretKey）。
        String secretId = "AKIDlX4YbO2CG6h2AWwS2MTMbbRFqB9t3fOr";
        String secretKey = "PZVHlaAXifNp8BzXrzsVs76sOfkZ8RaU";
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
        // 2 设置 bucket 的区域, COS 地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        // clientConfig 中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者常见问题 Java SDK 部分。
        Region region = new Region("ap-chengdu");
        ClientConfig clientConfig = new ClientConfig(region);
        // 3 生成 cos 客户端。
        cosClient = new COSClient(cred, clientConfig);
    }

    @Override
    public PutObjectResult putObject(InputStream in, int length,String Appkey) {
        PutObjectResult putObjectResult = null;
        try {
            File localFile = new File("C:\\Users\\xuwb-b\\Desktop\\point.txt");
//        String bucketName = "bucket1st-1259373836";
//        String key = "luckymoney/test.txt";
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, Appkey, localFile);
        putObjectResult = cosClient.putObject(putObjectRequest);
         } catch (
        CosServiceException serverException) {
        serverException.printStackTrace();
         } catch (
        CosClientException clientException) {
        clientException.printStackTrace();
    }
        return putObjectResult;
    }

    @Override
    public void deleteObject(String key) {
        try {
            // 指定对象所在的存储桶
//            String bucketName = "bucket1st-1259373836";
            // 指定对象在 COS 上的对象键
            cosClient.deleteObject(bucketName, key);
        } catch (CosServiceException serverException) {
            serverException.printStackTrace();
        } catch (CosClientException clientException) {
            clientException.printStackTrace();
        }
    }


}
