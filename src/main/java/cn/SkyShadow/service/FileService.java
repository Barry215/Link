package cn.SkyShadow.service;

import cn.SkyShadow.dto.excution.Excution;
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
    Excution UpdateVoice(voice voice);

    /**
     * 上传视频
     * @param video 视频
     * @return 执行结果
     */
    Excution UpdateVideo(video video);

    /**
     * 上传图片
     * @param imagine 图片
     * @return 执行结果
     */
    Excution UpdateImage(imagine imagine);

    /**
     * 上传表情
     * @param expr 表情
     * @return 执行结果
     */
    Excution UpdateExpr(expr expr);
    /**
     * 特定角色为组织/部门上传文件
     * @param file 文件
     * @return 执行结果
     */
    Excution UpdateFile(file file);

    /**
     * 特定角色为组织/部门上传文件组
     * @param filegroup 文件组
     * @return 执行结果
     */
    Excution UpdateFileGroup(filegroup filegroup);
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
    Excution DeleteFile(Long fileId);
    /**
     * 特定角色删除组织/部门文件组
     * @param filegroupId 文件组ID
     * @return 执行结果
     */
    Excution DeleteFileGroup(Long filegroupId);

    /**
     * 向组织公共区域上传文件
     * @param orgId 组织ID
     * @param fileId 文件ID
     * @return 执行结果
     */
    Excution UpdateFileToOrg(Long orgId,Long fileId);

    /**
     * 移除组织的文件
     * @param orgId 组织ID
     * @param fileId 文件ID
     * @return 执行结果
     */
    Excution RemoveFileFromOrg(Long orgId,Long fileId);
    /**
     * 向组织公共区域上传文件组
     * @param orgId 组织ID
     * @param fileGroupId 文件ID
     * @return 执行结果
     */
    Excution UpdateFileGroupToOrg(Long orgId,Long fileGroupId);

    /**
     * 移除组织的文件组
     * @param orgId 组织ID
     * @param fileGroupId 文件ID
     * @return 执行结果
     */
    Excution RemoveFileGroupFromOrg(Long orgId,Long fileGroupId);
}