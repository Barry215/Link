package cn.SkyShadow.dao;

import org.apache.ibatis.annotations.Param;
import cn.SkyShadow.model.usergroup;

public interface usergroupMapper {
	int deleteByPrimaryKey(Long groupId);

	int insert(usergroup record);

	usergroup selectUsergroup(Long groupId);

	int adduser(@Param("userId") Long userId, @Param("groupId") Long groupId);

}