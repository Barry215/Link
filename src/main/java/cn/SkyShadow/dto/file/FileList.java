package cn.SkyShadow.dto.file;

import cn.SkyShadow.model.file;
import cn.SkyShadow.model.filegroup;

import java.util.List;

/**
 * 文件列表
 * Created by RichardW on 9/12/2016.
 */
public class FileList {
    private  List<file> fileList;
    private  List<filegroup> filegroupList;

    public List<file> getFileList() {
        return fileList;
    }

    public void setFileList(List<file> fileList) {
        this.fileList = fileList;
    }
}
