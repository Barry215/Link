package cn.SkyShadow.dao;

import cn.SkyShadow.model.session;

import java.util.List;

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
    /**
     * 获取当前拥有的所有会话
     * @param userId 用户ID
     * @return 会话列表
     */
    List<session> GetAllSession(Long userId);// TODO: 9/16/2016
}