package cn.SkyShadow.model;

public class FriendGroup {
	private Long friendGroupId;

	private String name;

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "FriendGroup [friendGroupId=" + friendGroupId + ", name=" + name
				+ ", User=" + user + "]";
	}

	public FriendGroup() {
	}

	public FriendGroup(String name, User user) {
		super();
		this.name = name;
		this.user = user;
	}

	public Long getFriendGroupId() {
		return friendGroupId;
	}

	public void setFriendGroupId(Long friendGroupId) {
		this.friendGroupId = friendGroupId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

}