package cn.SkyShadow.service;

import cn.SkyShadow.dto.execution.BaseExecution;
import cn.SkyShadow.dto.file.FileList;
import cn.SkyShadow.model.*;

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
     * 特定角色为组织/部门上传文件组
     * @param fileGroup 文件组
     * @return 执行结果
     */
    BaseExecution UpdateFileGroup(FileGroup fileGroup);
    /**
     * 特定角色获取组织/部门文件列表
     * @param organizationID 组织
     * @return 执行结果
     */
    FileList GetFileList(Long organizationID);

    /**
     * 特定角色删除组织/部门文件
     * @param fileId 文件ID
     * @return 执行结果
     */
    BaseExecution DeleteFile(Long fileId);
    /**
     * 特定角色删除组织/部门文件组
     * @param fileGroupId 文件组ID
     * @return 执行结果
     */
    BaseExecution DeleteFileGroup(Long fileGroupId);

    /**
     * 向组织公共区域上传文件
     * @param orgId 组织ID
     * @param fileId 文件ID
     * @return 执行结果
     */
    BaseExecution UpdateFileToOrg(Long orgId, Long fileId);

    /**
     * 移除组织的文件
     * @param orgId 组织ID
     * @param fileId 文件ID
     * @return 执行结果
     */
    BaseExecution RemoveFileFromOrg(Long orgId, Long fileId);
    /**
     * 向组织公共区域上传文件组
     * @param orgId 组织ID
     * @param fileGroupId 文件ID
     * @return 执行结果
     */
    BaseExecution UpdateFileGroupToOrg(Long orgId, Long fileGroupId);

    /**
     * 移除组织的文件组
     * @param orgId 组织ID
     * @param fileGroupId 文件ID
     * @return 执行结果
     */
    BaseExecution RemoveFileGroupFromOrg(Long orgId, Long fileGroupId);
}
