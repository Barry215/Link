package cn.SkyShadow.model;

import java.util.List;

public class message {
	private Long msgId;

	private List<content> contentList;

	private session sessionId;

	private user user;

	public message() {
		super();
	}

	@Override
	public String toString() {
		return "message [msgId=" + msgId + ", contentList=" + contentList
				+ ", sessionId=" + sessionId + ", user=" + user + "]";
	}

	public message(List<content> contentList, session sessionId,
			cn.SkyShadow.model.user user) {
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

	public List<content> getContentList() {
		return contentList;
	}

	public void setContentList(List<content> contentList) {
		this.contentList = contentList;
	}

	public session getSessionId() {
		return sessionId;
	}

	public void setSessionId(session sessionId) {
		this.sessionId = sessionId;
	}

	public user getUser() {
		return user;
	}

	public void setUser(user user) {
		this.user = user;
	}

}