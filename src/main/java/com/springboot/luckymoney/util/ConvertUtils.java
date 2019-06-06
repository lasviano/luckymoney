package com.springboot.luckymoney.util;

import com.bimface.bean.GeneralResponse;
import com.springboot.luckymoney.dao.FileBean;
import com.springboot.luckymoney.entity.FileEntity;
import org.apache.commons.lang.time.DateFormatUtils;

import java.util.Date;

public class ConvertUtils {
    public static FileBean toFileBean(FileEntity file) {
        FileBean fileBean = new FileBean();
        fileBean.setFileid( file.getId());
        fileBean.setName(file.getName());
        fileBean.setLength(file.getLength());
        fileBean.setCreateTime(DateFormatUtils.format(new Date(), GeneralResponse.DATE_FORMAT));
        return fileBean;
    }
}
