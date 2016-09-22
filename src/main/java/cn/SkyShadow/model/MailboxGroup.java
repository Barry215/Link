package cn.SkyShadow.model;

public class MailboxGroup {
	private Long groupId;

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	@Override
	public String toString() {
		return "MailboxGroup [groupId=" + groupId + "]";
	}

}