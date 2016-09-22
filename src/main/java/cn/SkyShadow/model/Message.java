package cn.SkyShadow.model;

import java.util.List;

public class Message {
	private Long msgId;

	private List<Content> contentList;

	private Session sessionId;

	private User user;

	public Message() {
		super();
	}

	@Override
	public String toString() {
		return "Message [msgId=" + msgId + ", contentList=" + contentList
				+ ", sessionId=" + sessionId + ", User=" + user + "]";
	}

	public Message(List<Content> contentList, Session sessionId,
				   User user) {
		super();
		this.contentList = contentList;
		this.sessionId = sessionId;
		this.user = user;
	}

	public Long getMsgId() {
		return msgId;
	}

	public void setMsgId(Long msgId) {
		this.msgId = msgId;
	}

	public List<Content> getContentList() {
		return contentList;
	}

	public void setContentList(List<Content> contentList) {
		this.contentList = contentList;
	}

	public Session getSessionId() {
		return sessionId;
	}

	public void setSessionId(Session sessionId) {
		this.sessionId = sessionId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}