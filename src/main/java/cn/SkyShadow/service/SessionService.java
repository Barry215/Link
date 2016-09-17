package cn.SkyShadow.service;

import cn.SkyShadow.dto.excution.Execution;
import cn.SkyShadow.model.*;

import java.util.List;

public interface SessionService {

    /**
     * 获取当前拥有的所有会话
     *
     * @param userId 用户ID
     * @return 会话列表
     */
    List<session> GetAllSession(Long userId);

    /**
     * 发送消息
     *
     * @param message 信息
     * @return 执行结果
     */
    Execution SendMessage(message message);

    /**
     * 撤回消息
     *
     * @param messageId 信息ID
     * @return 执行结果
     */
    Execution RollBackMessage(Long messageId);


    /**
     * 获取当前所有会话的未读信息数目
     *
     * @param userId 用户ID
     * @return 执行结果
     */
    int GetNotReadMessageNum(Long userId);

    /**
     * 获取当前所有会话的未读信息
     *
     * @param userId 用户ID
     * @return 执行结果
     */
    List<message> GetNotReadMessage(Long userId);

    /**
     * 把未读消息编程已读消息
     *
     * @param IdList 一群ID
     * @return 执行结果
     */
    Execution ReadMessage(List<String> IdList);
}
