package cn.SkyShadow.service.Impl;

import cn.SkyShadow.dto.excution.Excution;
import cn.SkyShadow.model.Apply;
import cn.SkyShadow.model.Receipt;
import cn.SkyShadow.model.friendgroup;
import cn.SkyShadow.model.user;
import cn.SkyShadow.service.FriendSeivice;

import java.util.List;

/**
 * 好友处理器
 * Created by Richard on 16/9/13.
 */
public class FriendSeiviceImpl implements FriendSeivice {
    @Override
    public List<user> Search(String str) {
        return null;
    }

    @Override
    public Excution AddFriend(Apply apply) {
        return null;
    }

    @Override
    public Excution AddFriendCallBack(Receipt receipt) {
        return null;
    }

    @Override
    public Excution CreateFriendGroup(friendgroup friendgroup) {
        return null;
    }

    @Override
    public Excution ModifyFriendGroup(friendgroup friendgroup) {
        return null;
    }

    @Override
    public Excution Deletefriend(user a, user b) {
        return null;
    }
}
