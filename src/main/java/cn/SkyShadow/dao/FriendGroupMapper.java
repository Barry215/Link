package cn.SkyShadow.dao;

import cn.SkyShadow.model.FriendGroup;

public interface FriendGroupMapper {
    /**
     * 删除一个好友分组
     * @param friendGroupId 好友分组ID
     * @return 执行结果
     */
    int deleteByPrimaryKey(Long friendGroupId);

    /**
     * 新建一个好友分组
     * @param record 好友分组
     * @return 执行结果
     */
    int insert(FriendGroup record);

    /**
     * 查询好友分组
     * @param friendGroupId 好友分组ID
     * @return 执行结果
     */
    FriendGroup selectByPrimaryKey(Long friendGroupId);
}