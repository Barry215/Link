package cn.SkyShadow.dao;

import cn.SkyShadow.model.File;

public interface FileMapper {
    /**
     * 删除文件
     * @param fileId 文件ID
     * @return 执行结果
     */
    int deleteByPrimaryKey(Long fileId);

    /**
     * 新建一个文件
     * @param record 文件
     * @return 执行结果
     */
    int insert(File record);

    /**
     * 查询文件
     * @param fileId 文件ID
     * @return 文件信息
     */
    File selectByPrimaryKey(Long fileId);

    /**
     * 更新文件信息1
     * @param record 文件信息
     * @return 执行结果
     */
    int updateByPrimaryKeySelective(File record);

    /**
     * 更新文件信息2
     * @param record 文件信息
     * @return 执行结果
     */
    int updateByPrimaryKey(File record);

    /**
     * 向组织上传文件
     * @param orgId 组织
     * @param fileId 文件ID
     * @return 执行结果
     */
    int AddFileToOrg(Long orgId, Long fileId);//TODO

    /**
     * 从组织移除文件
     * @param orgId 组织ID
     * @param fileId 文件ID
     * @return 执行结果
     */
    int RemoveFileFromOrg(Long orgId, Long fileId);//todo
}