package cn.SkyShadow.model;

import java.util.Date;

public class session {
	private Long sessionId;

	private usergroup usergroupId;

	private Date startTime;

	private Date endTime;

	public session(usergroup usergroupId, Date startTime, Date endTime) {
		super();
		this.usergroupId = usergroupId;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public session() {
		super();
	}

	@Override
	public String toString() {
		return "session [sessionId=" + sessionId + ", usergroupId="
				+ usergroupId + ", startTime=" + startTime + ", endTime="
				+ endTime + "]";
	}

	public Long getSessionId() {
		return sessionId;
	}

	public void setSessionId(Long sessionId) {
		this.sessionId = sessionId;
	}

	public usergroup getUsergroupId() {
		return usergroupId;
	}

	public void setUsergroupId(usergroup usergroupId) {
		this.usergroupId = usergroupId;
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