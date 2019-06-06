package com.springboot.luckymoney.event;

import com.springboot.luckymoney.entity.FileEntity;
import org.springframework.context.ApplicationEvent;

public class FileUpLoadCompleteEvent extends ApplicationEvent {

    private FileEntity file;
    private Boolean ispulled;

    public FileUpLoadCompleteEvent(Object object, FileEntity file, boolean b) {
        super(object);
        this.file = file;
        ispulled = b;
    }

    public FileEntity getFile() {
        return file;
    }

    public void setFile(FileEntity file) {
        this.file = file;
    }

    public Boolean getIspulled() {
        return ispulled;
    }

    public void setIspulled(Boolean ispulled) {
        this.ispulled = ispulled;
    }
}
