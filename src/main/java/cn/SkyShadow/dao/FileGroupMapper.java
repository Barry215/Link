package cn.SkyShadow.dao;

import cn.SkyShadow.model.FileGroup;
import org.apache.ibatis.annotations.Param;

public interface FileGroupMapper {
	/**
	 * 删除文件组
	 * @param fileGroupId 文件组ID
	 * @return 执行结果
	 */
	int deleteByPrimaryKey(Long fileGroupId);

    /**
     * 新建一个文件组
     * @param record 文件组
     * @return 执行结果
     */
	int insert(FileGroup record);

    /**
     * 根据文件组ID查询文件组
     * @param fileGroupId 文件组ID
     * @return 文件组
     */
	FileGroup selectByPrimaryKey(Long fileGroupId);

    /**
     * 向文件组添加文件
     * @param file_id 文件ID
     * @param fileGroupId 文件组ID
     * @return 执行结果
     */
	int addFile(@Param("file_id") Long file_id,
                @Param("fileGroupId") Long fileGroupId);
}