package cn.SkyShadow.model;

import cn.SkyShadow.basic_component.JsonFormatUtil;

import java.util.List;

public class UserGroup {
	private Long groupId;

	private List<User> users;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
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
		return JsonFormatUtil.getJsonFormatString(this);
	}

}