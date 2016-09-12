package cn.SkyShadow.dao;

import cn.SkyShadow.model.content;

import java.util.List;

public interface contentMapper {
    /**
     * 删除指定的消息
     * @param contentID 消息ID
     * @return 执行结果 成功返回1
     */
    int deleteByPrimaryKey(Long contentID);

    /**
     * 发送消息
     * @param record 消息
     * @return 执行结果,成功返回1
     */
    int insertSelective(content record);

    /**
     * 根据消息的ID来获取消息
     * @param contentID 消息ID
     * @return 执行结果,成功返回1
     */
    List<content> selectByPrimaryKey(Long contentID);

    /**
     * 更新消息(废弃)
     * @param record 消息
     * @return 执行结果
     */
    int updateByPrimaryKeySelective(content record);
}