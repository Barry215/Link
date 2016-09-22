package cn.SkyShadow.model;

import java.util.List;

public class Mailbox {
	private Long mailboxId;

	private String belongType;

	private User user;

	private Occupation occupation;

	private List<Mail> mails;

	public Mailbox() {
		super();
	}

	@Override
	public String toString() {
		return "Mailbox [mailboxId=" + mailboxId + ", belongType=" + belongType
				+ ", User=" + user + ", Occupation=" + occupation + ", mails="
				+ mails + "]";
	}

	public Mailbox(String belongType) {
		super();
		this.belongType = belongType;
	}

	public List<Mail> getMails() {
		return mails;
	}

	public void setMails(List<Mail> mails) {
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Occupation getOccupation() {
		return occupation;
	}

	public void setOccupation(Occupation occupation) {
		this.occupation = occupation;
	}

}