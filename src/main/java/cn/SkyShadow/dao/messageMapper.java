package cn.SkyShadow.dao;

import cn.SkyShadow.model.message;

import java.util.List;

public interface messageMapper {
    /**
     * 删除信息
     * @param msgId 信息ID
     * @return 执行结果
     */
	int deleteByPrimaryKey(Long msgId);

    /**
     * 新建消息
     * @param record 消息
     * @return 执行结果
     */
	int insert(message record);

    /**
     * 查询消息
     * @param msgId 消息ID
     * @return 执行结果
     */
	message selectByPrimaryKey(Long msgId);
    /**
     * 获取所有未读消息数目
     * @param userId 用户ID
     * @return 消息列表
     */
    int GetNotReadMessageNum(Long userId);// TODO: 9/16/2016
    /**
     * 获取当前所有会话的未读信息
     *
     * @param userId 用户ID
     * @return 执行结果
     */
    List<message> GetNotReadMessage(Long userId);// TODO: 9/16/2016

    /**
     * 阅读信息
     * @param IdList 阅读列表
     * @return 执行结果
     */
    int ReadMessage(List<String> IdList);
}