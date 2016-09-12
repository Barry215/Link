package cn.SkyShadow.dao;

import org.apache.ibatis.annotations.Param;
import cn.SkyShadow.model.usergroup;

public interface usergroupMapper {
    /**
     * 删除会话组
     * @param groupId 组ID
     * @return 执行结果
     */
	int deleteByPrimaryKey(Long groupId);

    /**
     * 插入会话组
     * @param record 会话
     * @return 执行结果
     */
	int insert(usergroup record);

    /**
     * 用户组查询
     * @param groupId 组ID
     * @return 执行结果
     */
	usergroup selectUsergroup(Long groupId);

    /**
     * 向用户组添加用户
     * @param userId 用户ID
     * @param groupId 组ID
     * @return 执行结果
     */
	int adduser(@Param("userId") Long userId, @Param("groupId") Long groupId);

}