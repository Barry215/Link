package cn.SkyShadow.service;

import cn.SkyShadow.dto.excution.Excution;
import cn.SkyShadow.model.*;

import java.util.List;

public interface FriendSeivice {

    /**
     * 搜索用户
     * @param str 模糊字段
     * @return 用户信息列表
     */
    List<user> Search(String str);

    /**
     * 加好友申请
     * @param apply 申请
     * @return 执行结果
     */
    Excution AddFriend(Apply apply);

    /**
     * 处理加好友申请
     * @param receipt 回执
     * @return 执行结果
     */
    Excution AddFriendCallBack(Receipt receipt);

    /**
     * 创建好友分组
     * @param friendgroup 好友分组
     * @return 执行结果
     */
    Excution CreateFriendGroup(friendgroup friendgroup);

    /**
     * 编辑好友分组
     * @param friendgroup 好友分组信息
     * @return 执行结果
     */
    Excution ModifyFriendGroup(friendgroup friendgroup);

    /**
     * 删除好友
     * @param friendId 好友关系ID
     * @return 执行结果
     */
    Excution Deletefriend(Long friendId);

    /**
     * 删除好友分组
     * @param friendGroupId 好友分组ID
     * @return 执行结果
     */
    Excution deleteFriendGroup(Long friendGroupId);
}
