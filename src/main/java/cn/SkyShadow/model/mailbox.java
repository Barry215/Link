package cn.SkyShadow.model;

import java.util.List;

public class mailbox {
	private Long mailboxId;

	private String belongType;

	private user user;

	private occupation occupation;

	private List<mail> mails;

	public mailbox() {
		super();
	}

	@Override
	public String toString() {
		return "mailbox [mailboxId=" + mailboxId + ", belongType=" + belongType
				+ ", user=" + user + ", occupation=" + occupation + ", mails="
				+ mails + "]";
	}

	public mailbox(String belongType) {
		super();
		this.belongType = belongType;
	}

	public List<mail> getMails() {
		return mails;
	}

	public void setMails(List<mail> mails) {
		this.mails = mails;
	}

	public Long getMailboxId() {
		return mailboxId;
	}

	public void setMailboxId(Long mailboxId) {
		this.mailboxId = mailboxId;
	}

	public String getBelongType() {
		return belongType;
	}

	public void setBelongType(String belongType) {
		this.belongType = belongType == null ? null : belongType.trim();
	}

	public user getUser() {
		return user;
	}

	public void setUser(user user) {
		this.user = user;
	}

	public occupation getOccupation() {
		return occupation;
	}

	public void setOccupation(occupation occupation) {
		this.occupation = occupation;
	}

}