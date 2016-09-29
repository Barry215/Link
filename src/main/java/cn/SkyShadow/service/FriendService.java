package cn.SkyShadow.service;

import cn.SkyShadow.dto.execution.BaseExecution;
import cn.SkyShadow.model.*;
import cn.SkyShadow.model.apply.applyChildren.AddFriend;
import cn.SkyShadow.model.apply.Receipt;

import java.util.List;

public interface FriendService {

    /**
     * 搜索用户
     * @param str 模糊字段
     * @return 用户信息列表
     */
    List<User> Search(String str);

    /**
     * 处理加好友申请
     * @param receipt 回执
     * @return 执行结果
     */
    BaseExecution AddFriendCallBack(Receipt<AddFriend> receipt);

    /**
     * 创建好友分组
     * @param friendGroup 好友分组
     * @return 执行结果
     */
    BaseExecution CreateFriendGroup(FriendGroup friendGroup);

    /**
     * 编辑好友分组
     * @param friendGroup 好友分组信息
     * @return 执行结果
     */
    BaseExecution ModifyFriendGroup(FriendGroup friendGroup);

    /**
     * 删除好友
     * @param friendId 好友关系ID
     * @return 执行结果
     */
    BaseExecution DeleteFriend(Long friendId);

    /**
     * 删除好友分组
     * @param friendGroupId 好友分组ID
     * @return 执行结果
     */
    BaseExecution deleteFriendGroup(Long friendGroupId);
}
