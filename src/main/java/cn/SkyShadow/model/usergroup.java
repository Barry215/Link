package cn.SkyShadow.model;

import java.util.List;

public class usergroup {
	private Long groupId;

	private List<user> users;

	public List<user> getUsers() {
		return users;
	}

	public void setUsers(List<user> users) {
		this.users = users;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	@Override
	public String toString() {
		return "usergroup [groupId=" + groupId + ", users=" + users + "]";
	}

}