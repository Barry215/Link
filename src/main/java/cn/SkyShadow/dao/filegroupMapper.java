package cn.SkyShadow.dao;

import org.apache.ibatis.annotations.Param;
import cn.SkyShadow.model.filegroup;

public interface filegroupMapper {
	int deleteByPrimaryKey(Long filegroupId);

	int insert(filegroup record);

	filegroup selectByPrimaryKey(Long filegroupId);

	int addfile(@Param("file_id") Long file_id,
                @Param("filegroup_id") Long filegroup_id);
}