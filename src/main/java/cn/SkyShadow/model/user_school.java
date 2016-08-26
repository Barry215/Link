package cn.SkyShadow.model;

import java.util.Date;

public class user_school extends user_schoolKey {

	private Date admissionTime;

	public Date getAdmissionTime() {
		return admissionTime;
	}

	public void setAdmissionTime(Date admissionTime) {
		this.admissionTime = admissionTime;
	}

	public user_school(user userId, school schoolId, Date admissionTime) {
		super(userId, schoolId);
		this.admissionTime = admissionTime;
	}

	public user_school() {
		super();
	}

	@Override
	public String toString() {
		return "user_schoolKey [userId=" + getUserId() + ", schoolId=" + getSchoolId()
				+ "],user_school [admissionTime=" + admissionTime + "]";
	}
	
	
}