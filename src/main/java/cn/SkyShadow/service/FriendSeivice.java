package cn.SkyShadow.service;

import cn.SkyShadow.model.content;
import cn.SkyShadow.model.friendgroup;
import cn.SkyShadow.model.user;

import java.util.List;

public interface FriendSeivice {
	 List<friendgroup> GetFriendGroupList(user user);

	 List<user> SearchUser(String str);

	 void ApplyAddUser(content content);

	 int AddUser(content reply);

	 int CreateNewFriendGroup(user u, friendgroup f);

	 int ModifyFriendGroup(user u, friendgroup f);
}
