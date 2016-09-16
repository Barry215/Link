package cn.SkyShadow.dao;

import cn.SkyShadow.model.friendgroup;

public interface friendgroupMapper {
    /**
     * 删除一个好友分组
     * @param friendgroupId 好友分组ID
     * @return 执行结果
     */
    int deleteByPrimaryKey(Long friendgroupId);

    /**
     * 新建一个好友分组
     * @param record 好友分组
     * @return 执行结果
     */
    int insert(friendgroup record);

    /**
     * 查询好友分组
     * @param friendgroupId 好友分组ID
     * @return 执行结果
     */
    friendgroup selectByPrimaryKey(Long friendgroupId);

    /**
     * 更新好友分组
     * @param friendgroup 好友分组
     * @return 执行结果
     */
    int update(friendgroup friendgroup);// TODO: 9/16/2016
}