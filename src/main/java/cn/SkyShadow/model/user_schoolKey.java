package cn.SkyShadow.model;

public class user_schoolKey {
	private user userId;

	private school schoolId;

	public user getUserId() {
		return userId;
	}

	public void setUserId(user userId) {
		this.userId = userId;
	}

	public school getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(school schoolId) {
		this.schoolId = schoolId;
	}

	public user_schoolKey(user userId, school schoolId) {
		super();
		this.userId = userId;
		this.schoolId = schoolId;
	}

	public user_schoolKey() {
		super();
	}

	@Override
	public String toString() {
		return "user_schoolKey [userId=" + userId + ", schoolId=" + schoolId
				+ "]";
	}
	

}
