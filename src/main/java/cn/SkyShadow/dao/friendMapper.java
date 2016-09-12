package cn.SkyShadow.dao;

import cn.SkyShadow.model.friend;

import java.util.List;

public interface friendMapper {
    /**
     * 删除好友
     * @param friendId 好友ID
     * @return 执行结果
     */
    int deleteByPrimaryKey(Long friendId);

    /**
     * 新建好友
     * @param record 好友
     * @return 执行结果
     */
    int insert(friend record);

    /**
     * 根据用户ID,查询用户的好友
     * @param userId 好友ID
     * @return 好友列表
     */
    List<friend> selectByPrimaryKey(Long userId);

    /**
     * 更新好友信息
     * @param record 好友
     * @return 执行结果
     */
    int updateByPrimaryKeySelective(friend record);

}