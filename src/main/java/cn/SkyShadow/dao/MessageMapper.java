package cn.SkyShadow.dao;

import cn.SkyShadow.model.Message;

import java.util.List;

public interface MessageMapper {
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
	int insert(Message record);

    /**
     * 查询消息
     * @param msgId 消息ID
     * @return 执行结果
     */
	Message selectByPrimaryKey(Long msgId);
    /**
     * 获取所有未读消息数目
     * @param userId 用户ID
     * @return 消息列表
     */
    int GetNotReadMessageNum(Long userId);
    /**
     * 获取当前所有会话的未读信息
     *
     * @param userId 用户ID
     * @return 执行结果
     */
    List<Message> GetNotReadMessage(Long userId);

    /**
     * 阅读信息
     * @param IdList 阅读列表
     * @return 执行结果
     */
    int ReadMessage(List<String> IdList);
}