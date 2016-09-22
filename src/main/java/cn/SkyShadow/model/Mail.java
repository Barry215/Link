package cn.SkyShadow.model;

import java.util.Date;
import java.util.List;

public class Mail {
	private Long mailId;

	private String headline;

	private String subLine;

	private List<Content> content;

	private Mailbox senderMailbox;

	private MailboxGroup receivedMailboxGroup;

	private Date sendTime;

	private String isRead;

	private String isDeleted;

	public Mail(String headline, String subLine, List<Content> content,
				Mailbox senderMailbox, MailboxGroup receivedMailboxGroup) {
		super();
		this.headline = headline;
		this.subLine = subLine;
		this.content = content;
		this.senderMailbox = senderMailbox;
		this.receivedMailboxGroup = receivedMailboxGroup;
	}

	public Mail() {
		super();
	}

	@Override
	public String toString() {
		return "Mail [mailId=" + mailId + ", headline=" + headline
				+ ", subLine=" + subLine + ", Content=" + content
				+ ", senderMailbox=" + senderMailbox
				+ ", receivedMailboxGroup=" + receivedMailboxGroup
				+ ", sendTime=" + sendTime + ", isRead=" + isRead
				+ ", isDeleted=" + isDeleted + "]";
	}

	public Long getMailId() {
		return mailId;
	}

	public void setMailId(Long mailId) {
		this.mailId = mailId;
	}

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline == null ? null : headline.trim();
	}

	public String getSubLine() {
		return subLine;
	}

	public void setSubLine(String subLine) {
		this.subLine = subLine == null ? null : subLine.trim();
	}

	public List<Content> getContent() {
		return content;
	}

	public void setContent(List<Content> content) {
		this.content = content;
	}

	public Mailbox getSenderMailbox() {
		return senderMailbox;
	}

	public void setSenderMailbox(Mailbox senderMailbox) {
		this.senderMailbox = senderMailbox;
	}

	public MailboxGroup getReceivedMailboxGroup() {
		return receivedMailboxGroup;
	}

	public void setReceivedMailboxGroup(MailboxGroup receivedMailboxGroup) {
		this.receivedMailboxGroup = receivedMailboxGroup;
	}

	public String getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public String getIsRead() {
		return isRead;
	}

	public void setIsRead(String isRead) {
		this.isRead = isRead == null ? null : isRead.trim();
	}
}