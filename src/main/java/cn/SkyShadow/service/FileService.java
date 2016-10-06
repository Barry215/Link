package cn.SkyShadow.service;

import cn.SkyShadow.dto.execution.BaseExecution;
import cn.SkyShadow.dto.file.FileList;
import cn.SkyShadow.model.*;
import cn.SkyShadow.model.File;

import java.io.*;
import java.util.List;

/**
 * 文件管理器
 * Created by Richard on 16/9/13.
 */
public interface FileService {
    /**
     * 上传音频
     * @param voice 语音
     * @return 执行结果
     */
    BaseExecution UpdateVoice(Voice voice);

    /**
     * 上传视频
     * @param video 视频
     * @return 执行结果
     */
    BaseExecution UpdateVideo(Video video);

    /**
     * 上传图片
     * @param imagine 图片
     * @return 执行结果
     */
    BaseExecution UpdateImage(Imagine imagine);

    /**
     * 批量上传图片
     * @param imagines 图片信息
     * @return 执行结果
     */
    BaseExecution UpdateImage(List<Imagine> imagines);

    /**
     * 上传表情
     * @param expr 表情
     * @return 执行结果
     */
    BaseExecution UpdateExpr(Expr expr);
    /**
     * 特定角色为组织/部门上传文件
     * @param file 文件
     * @return 执行结果
     */
    BaseExecution UpdateFile(File file);

    /**
     * 批量上传文件
     * @param files 文件
     * @return 执行结果
     */
    BaseExecution UpdateFile(List<File> files);

    /**
     * 特定角色为组织/部门上传文件组
     * @param fileGroup 文件组
     * @return 执行结果
     */
    BaseExecution UpdateFileGroup(FileGroup fileGroup);
}
