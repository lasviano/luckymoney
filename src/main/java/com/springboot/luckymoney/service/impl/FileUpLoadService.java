package com.springboot.luckymoney.service.impl;

import com.alibaba.fastjson.JSON;
import com.bimface.utils.IdGenerator;
import com.qcloud.cos.model.PutObjectResult;
import com.springboot.luckymoney.dao.FileBean;
import com.springboot.luckymoney.entity.FileEntity;
import com.springboot.luckymoney.event.FileUpLoadCompleteEvent;
import com.springboot.luckymoney.exception.LuckymoneyException;
import com.springboot.luckymoney.mapper.FileEntityMapper;
import com.springboot.luckymoney.service.ObjectService;
import com.springboot.luckymoney.util.ConvertUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import java.io.InputStream;

@Service
public class FileUpLoadService {

    private static final Logger logger = LoggerFactory.getLogger(FileUpLoadService.class);

    @Autowired
    private FileEntityMapper fileEntityMapper;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private ObjectService objectService;

    public FileBean upload(String name, String sourceId, InputStream in, int length,String Appkey) {
        // 检查InputStream
        if (in == null){
            throw new LuckymoneyException(100,"fail inputstream");
        }

        // 构造FileEntity
        FileEntity file = buildFileEntity(name,length,sourceId,Appkey);

        // 上传文件流到COS
        PutObjectResult putObjectResult = objectService.putObject(in,length,Appkey);
        logger.info(JSON.toJSONString(putObjectResult));

        // 保存数据到DB
        fileEntityMapper.insert(file);

        //事件通知
        applicationContext.publishEvent(new FileUpLoadCompleteEvent(this,file,false));
        logger.info("after UpLoadPublishEvent");

        return ConvertUtils.toFileBean(file);
    }

    private FileEntity buildFileEntity(String name, int length, String sourceId,String Appkey) {
        FileEntity file = new FileEntity();
        file.setId((int) IdGenerator.nextId());
        file.setName(name);
        file.setLength(length);
        file.setSourceId(sourceId);
        file.setAppkey(Appkey);
        return file;
    }
}
