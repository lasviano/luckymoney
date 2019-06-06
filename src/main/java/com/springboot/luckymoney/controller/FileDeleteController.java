package com.springboot.luckymoney.controller;

import com.bimface.bean.GeneralResponse;
import com.springboot.luckymoney.service.FileEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileDeleteController {

    @Autowired
    private FileEntityService fileEntityService;

    @DeleteMapping("/deleteFile")
    public GeneralResponse deleteFile(@RequestParam(value = "fileid") int fileid ) {
        fileEntityService.deleteFile(fileid);
        return new GeneralResponse(null);
    }
}
