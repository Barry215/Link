package cn.SkyShadow.model;

import java.util.Date;
import java.util.List;

public class mail {
	private Long mailId;

	private String headline;

	private String subline;

	private List<content> content;

	private mailbox senderMailbox;

	private mailboxgroup receivedMailboxGroup;

	private Date sendTime;

	private String isreaded;

	private String isdeleted;

	public mail(String headline, String subline, List<content> content,
			mailbox senderMailbox, mailboxgroup receivedMailboxGroup) {
		super();
		this.headline = headline;
		this.subline = subline;
		this.content = content;
		this.senderMailbox = senderMailbox;
		this.receivedMailboxGroup = receivedMailboxGroup;
	}

	public mail() {
		super();
	}

	@Override
	public String toString() {
		return "mail [mailId=" + mailId + ", headline=" + headline
				+ ", subline=" + subline + ", content=" + content
				+ ", senderMailbox=" + senderMailbox
				+ ", receivedMailboxGroup=" + receivedMailboxGroup
				+ ", sendTime=" + sendTime + ", isreaded=" + isreaded
				+ ", isdeleted=" + isdeleted + "]";
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

	public String getSubline() {
		return subline;
	}

	public void setSubline(String subline) {
		this.subline = subline == null ? null : subline.trim();
	}

	public List<content> getContent() {
		return content;
	}

	public void setContent(List<content> content) {
		this.content = content;
	}

	public mailbox getSenderMailbox() {
		return senderMailbox;
	}

	public void setSenderMailbox(mailbox senderMailbox) {
		this.senderMailbox = senderMailbox;
	}

	public mailboxgroup getReceivedMailboxGroup() {
		return receivedMailboxGroup;
	}

	public void setReceivedMailboxGroup(mailboxgroup receivedMailboxGroup) {
		this.receivedMailboxGroup = receivedMailboxGroup;
	}

	public String getIsdeleted() {
		return isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public String getIsreaded() {
		return isreaded;
	}

	public void setIsreaded(String isreaded) {
		this.isreaded = isreaded == null ? null : isreaded.trim();
	}
}