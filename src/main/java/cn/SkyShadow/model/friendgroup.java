package cn.SkyShadow.model;

public class friendgroup {
	private Long friendgroupId;

	private String name;

	private user user;

	public user getUser() {
		return user;
	}

	public void setUser(user user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "friendgroup [friendgroupId=" + friendgroupId + ", name=" + name
				+ ", user=" + user + "]";
	}

	public friendgroup() {
		super();
	}

	public friendgroup(String name, user user) {
		super();
		this.name = name;
		this.user = user;
	}

	public Long getFriendgroupId() {
		return friendgroupId;
	}

	public void setFriendgroupId(Long friendgroupId) {
		this.friendgroupId = friendgroupId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

}