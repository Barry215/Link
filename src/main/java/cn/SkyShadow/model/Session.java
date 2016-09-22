package cn.SkyShadow.model;

import java.util.Date;

public class Session {
	private Long sessionId;

	private UserGroup userGroupId;

	private Date startTime;

	private Date endTime;

	public Session(UserGroup userGroupId, Date startTime, Date endTime) {
		super();
		this.userGroupId = userGroupId;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public Session() {
		super();
	}

	@Override
	public String toString() {
		return "Session [sessionId=" + sessionId + ", userGroupId="
				+ userGroupId + ", startTime=" + startTime + ", endTime="
				+ endTime + "]";
	}

	public Long getSessionId() {
		return sessionId;
	}

	public void setSessionId(Long sessionId) {
		this.sessionId = sessionId;
	}

	public UserGroup getUserGroupId() {
		return userGroupId;
	}

	public void setUserGroupId(UserGroup userGroupId) {
		this.userGroupId = userGroupId;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
}