package cn.SkyShadow.dao;

import org.apache.ibatis.annotations.Param;
import cn.SkyShadow.model.filegroup;

public interface filegroupMapper {
	/**
	 * 删除文件组
	 * @param filegroupId 文件组ID
	 * @return 执行结果
	 */
	int deleteByPrimaryKey(Long filegroupId);

    /**
     * 新建一个文件组
     * @param record 文件组
     * @return 执行结果
     */
	int insert(filegroup record);

    /**
     * 根据文件组ID查询文件组
     * @param filegroupId 文件组ID
     * @return 文件组
     */
	filegroup selectByPrimaryKey(Long filegroupId);

    /**
     * 向文件组添加文件
     * @param file_id 文件ID
     * @param filegroup_id 文件组ID
     * @return 执行结果
     */
	int addfile(@Param("file_id") Long file_id,
                @Param("filegroup_id") Long filegroup_id);

    /**
     * 向组织添加文件组
     * @param filegroupId 文件组ID
     * @param orgId 组织ID
     * @return 执行结果
     */
	int AddFileGroupToOrg(Long filegroupId,Long orgId);//// TODO: 9/14/2016

    /**
     * 向组织移除文件组
     * @param filegroupId 文件组ID
     * @param orgId 组织ID
     * @return 执行结果
     */
    int RemoveFileGroupfromOrg(Long filegroupId,Long orgId);//// TODO: 9/14/2016
}