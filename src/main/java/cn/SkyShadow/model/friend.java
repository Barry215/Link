package cn.SkyShadow.model;

public class friend {
	private Long friendId;

	private user userB;

	private friendgroup friendgroup;

	private String remarkName;

	public friend() {
		super();
	}

	public friend(user userB, cn.SkyShadow.model.friendgroup friendgroup,
			String remarkName) {
		super();
		this.userB = userB;
		this.friendgroup = friendgroup;
		this.remarkName = remarkName;
	}

	@Override
	public String toString() {
		return "friend [friendId=" + friendId + ", userB=" + userB
				+ ", friendgroup=" + friendgroup + ", remarkName=" + remarkName
				+ "]";
	}

	public String getRemarkName() {
		return remarkName;
	}

	public void setRemarkName(String remarkName) {
		this.remarkName = remarkName;
	}

	public Long getFriendId() {
		return friendId;
	}

	public void setFriendId(Long friendId) {
		this.friendId = friendId;
	}

	public user getUserB() {
		return userB;
	}

	public void setUserB(user userB) {
		this.userB = userB;
	}

	public friendgroup getFriendgroup() {
		return friendgroup;
	}

	public void setFriendgroup(friendgroup friendgroup) {
		this.friendgroup = friendgroup;
	}

}