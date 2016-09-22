package cn.SkyShadow.model;

import java.util.Date;

public class UserSchool extends UserSchoolKey {

	private Date admissionTime;

	public Date getAdmissionTime() {
		return admissionTime;
	}

	public void setAdmissionTime(Date admissionTime) {
		this.admissionTime = admissionTime;
	}

	public UserSchool(User userId, School schoolId, Date admissionTime) {
		super(userId, schoolId);
		this.admissionTime = admissionTime;
	}

	public UserSchool() {
		super();
	}

	@Override
	public String toString() {
		return "UserSchoolKey [userId=" + getUserId() + ", schoolId=" + getSchoolId()
				+ "],UserSchool [admissionTime=" + admissionTime + "]";
	}
	
	
}