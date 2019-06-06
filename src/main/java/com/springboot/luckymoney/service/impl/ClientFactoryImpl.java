package com.springboot.luckymoney.service.impl;

import com.glodon.paas.foundation.objectstorage.ObjectClient;
import com.springboot.luckymoney.service.ClientFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ClientFactoryImpl implements ClientFactory {

    @Value("${fileBucketName}")
    private String fileBucketName;

    private ObjectClient objectClient;

    @Override
    public ObjectClient getObjectStorageClient() {
        return objectClient;
    }

    @Override
    public String getFileBucket() {
        return fileBucketName;
    }
}
