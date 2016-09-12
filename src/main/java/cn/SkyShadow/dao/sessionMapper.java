package cn.SkyShadow.dao;

import cn.SkyShadow.model.session;

public interface sessionMapper {
    /**
     * 删除会话
     * @param sessionId 会话ID
     * @return 执行结果
     */
    int deleteByPrimaryKey(Long sessionId);

    /**
     * 新建一个会话
     * @param record 会话
     * @return 执行结果
     */
    int insert(session record);

    /**
     * 查询会话
     * @param sessionId 会话ID
     * @return 会话
     */
    session selectByPrimaryKey(Long sessionId);

}