package cn.SkyShadow.dao;

import cn.SkyShadow.model.message;

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
}