package com.springboot.luckymoney.service;

import com.glodon.paas.foundation.objectstorage.ObjectClient;

public interface ClientFactory {
    /**
     * 获取OSS客户端
     * @return
     */
    ObjectClient getObjectStorageClient();

    /**
     *获取文件所在的Bucket
     * @return
     */
    String getFileBucket();

}
