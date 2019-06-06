package com.springboot.luckymoney.service.impl;

import com.springboot.luckymoney.entity.FileEntity;
import com.springboot.luckymoney.exception.LuckymoneyException;
import com.springboot.luckymoney.mapper.FileEntityMapper;
import com.springboot.luckymoney.service.FileEntityService;
import com.springboot.luckymoney.service.ObjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileEntityServiceImpl implements FileEntityService {

    private static final Logger logger = LoggerFactory.getLogger(FileEntityServiceImpl.class);

    @Autowired
    private FileEntityMapper fileEntityMapper;

    @Autowired
    private ObjectService objectService;

    @Override
    public void deleteFile(int fileid) {
        //检查文件是否存在
        FileEntity file = getFileEntity(fileid);
        if (file==null){
            throw new LuckymoneyException(100,"no file to delete");
        }

        String key = file.getAppkey();
        objectService.deleteObject(key);
        logger.info("cos delete success!");

        fileEntityMapper.deleteById(fileid);
        logger.info("mysql.fileEntity delete success!");

    }

    private FileEntity getFileEntity(int fileid) {
        FileEntity file = fileEntityMapper.selectById(fileid);
        return file;
    }
}
