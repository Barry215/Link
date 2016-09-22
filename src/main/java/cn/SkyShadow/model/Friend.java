package cn.SkyShadow.model;

public class Friend {
	private Long friendId;

	private User userB;

	private FriendGroup friendGroup;

	private String remarkName;

	public Friend() {
		super();
	}

	public Friend(User userB, FriendGroup friendGroup,
				  String remarkName) {
		super();
		this.userB = userB;
		this.friendGroup = friendGroup;
		this.remarkName = remarkName;
	}

	@Override
	public String toString() {
		return "Friend [friendId=" + friendId + ", userB=" + userB
				+ ", FriendGroup=" + friendGroup + ", remarkName=" + remarkName
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

	public User getUserB() {
		return userB;
	}

	public void setUserB(User userB) {
		this.userB = userB;
	}

	public FriendGroup getFriendGroup() {
		return friendGroup;
	}

	public void setFriendGroup(FriendGroup friendGroup) {
		this.friendGroup = friendGroup;
	}

}