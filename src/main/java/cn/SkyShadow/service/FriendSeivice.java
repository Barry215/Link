package cn.SkyShadow.service;

import cn.SkyShadow.dto.excution.Excution;
import cn.SkyShadow.model.*;

import java.util.List;

public interface FriendSeivice {
/*
搜索用户
加好友申请
处理加好友申请
编辑分组
新建分组
删除好友
*/

    /**
     * 搜索用户
     * @param str 模糊字段
     * @return 用户信息列表
     */
    List<user> Search(String str);

    Excution AddFriend(Apply apply);

    Excution AddFriendCallBack(Receipt receipt);

    Excution CreateFriendGroup(friendgroup friendgroup);

    Excution ModifyFriendGroup(friendgroup friendgroup);

    Excution Deletefriend(user a, user b);
}
