package cn.SkyShadow.dto.file;

import cn.SkyShadow.model.File;
import cn.SkyShadow.model.FileGroup;

import java.util.List;

/**
 * 文件列表
 * Created by RichardW on 9/12/2016.
 */
public class FileList {
    private  List<File> fileList;
    private  List<FileGroup> fileGroupList;

    public List<File> getFileList() {
        return fileList;
    }

    public void setFileList(List<File> fileList) {
        this.fileList = fileList;
    }
}
