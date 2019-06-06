package com.springboot.luckymoney.event.listener;

import com.alibaba.fastjson.JSON;
import com.springboot.luckymoney.entity.FileEntity;
import com.springboot.luckymoney.event.FileUpLoadCompleteEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class FileUpLoadCompleteListener implements ApplicationListener<FileUpLoadCompleteEvent> {
    private static final Logger logger = LoggerFactory.getLogger(FileUpLoadCompleteListener.class);

    @Override
    public void onApplicationEvent(FileUpLoadCompleteEvent fileUpLoadCompleteEvent) {
        FileEntity file = fileUpLoadCompleteEvent.getFile();
        logger.info(JSON.toJSONString(file));
    }
}
