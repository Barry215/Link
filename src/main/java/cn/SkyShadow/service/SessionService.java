package cn.SkyShadow.service;

import cn.SkyShadow.dto.excution.Excution;
import cn.SkyShadow.model.*;

import java.util.List;

public interface SessionService {

    /**
     * 获取当前拥有的所有会话
     * @param userId 用户ID
     * @return 会话列表
     */
    List<session> GetAllSession(Long userId);

    /**
     * 发送消息
     * @param message 信息
     * @return 执行结果
     */
    Excution SendMessage(message message);

    /**
     * 撤回消息
     * @param messageId 信息ID
     * @return 执行结果
     */
    Excution RollBackMessage(Long messageId);

    /**
     * 	获取当前所有会话的未读信息数目
     * @param userId 用户ID
     * @return 执行结果
     */
    int GetNotReadMessageNum(Long userId);

    /**
     * 获取所有未读消息
     * @param userId 用户ID
     * @return 消息列表
     */
    List<message> GetNotReadMessage(Long userId);

    /**
     * 	把未读消息编程已读消息
     * @param IdList 一群ID
     * @return 执行结果
     */
    Excution ReadMessage(List<String> IdList);
}
