package cn.SkyShadow.model.apply.applyChildren;

import cn.SkyShadow.model.Friend;
import cn.SkyShadow.model.apply.Apply;

/**
 * 申请加好友
 * Created by RichardW on 9/22/2016.
 */
public class AddFriend extends Apply {
    private Friend friend;

    public Friend getFriend() {
        return friend;
    }

    public void setFriend(Friend friend) {
        this.friend = friend;
    }
}
