package cn.SkyShadow.dao;

import cn.SkyShadow.model.UserGroup;
import org.apache.ibatis.annotations.Param;

public interface UserGroupMapper {
    int insert(UserGroup userGroup);

    /**
     * 删除会话组
     *
     * @param groupId 组ID
     * @return 执行结果
     */
    int deleteByPrimaryKey(Long groupId);

    /**
     * 用户组查询
     *
     * @param groupId 组ID
     * @return 执行结果
     */
    UserGroup selectUserGroup(Long groupId);

    /**
     * 向用户组添加用户
     *
     * @param userId  用户ID
     * @param groupId 组ID
     * @return 执行结果
     */
    int addUser(@Param("userId") Long userId, @Param("groupId") Long groupId);
}