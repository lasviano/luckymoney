package com.springboot.luckymoney.controller;

import com.bimface.bean.GeneralResponse;
import com.springboot.luckymoney.dao.FileBean;
import com.springboot.luckymoney.service.impl.FileUpLoadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;

@RestController
public class FileUpLoadController {
    private static final Logger logger = LoggerFactory.getLogger(FileUpLoadController.class);

    @Autowired
    private FileUpLoadService fileUploadService;

    @PutMapping("/upfileload")
    public GeneralResponse<FileBean> upload(@RequestParam(value = "name") String name,
                                            @RequestParam(value = "sourceId",required = false) String sourceId,
                                            @RequestParam(value = "content-length") int length,
                                            @RequestParam(value = "Appkey") String Appkey,
                                            HttpServletRequest request){
        InputStream in = null;
        try {
            in = request.getInputStream();
        } catch (IOException e) {
            logger.info("get InputStream fail",e);
            e.printStackTrace();
        }
        FileBean fileBean = fileUploadService.upload(name, sourceId, in, length,Appkey);
        return new GeneralResponse<FileBean>(fileBean);
    }
}
