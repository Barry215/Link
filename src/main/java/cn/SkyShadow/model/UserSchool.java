package cn.SkyShadow.model;

import cn.SkyShadow.basic_component.JsonFormatUtil;

import java.util.Date;

public class UserSchool {
	private User userId;

	private School schoolId;

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public School getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(School schoolId) {
		this.schoolId = schoolId;
	}

	private Date admissionTime;

	public Date getAdmissionTime() {
		return admissionTime;
	}

	public void setAdmissionTime(Date admissionTime) {
		this.admissionTime = admissionTime;
	}

	@Override
	public String toString() {
		return JsonFormatUtil.getJsonFormatString(this);
	}
	
	
}