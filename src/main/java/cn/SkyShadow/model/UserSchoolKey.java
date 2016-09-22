package cn.SkyShadow.model;

public class UserSchoolKey {
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

	public UserSchoolKey(User userId, School schoolId) {
		super();
		this.userId = userId;
		this.schoolId = schoolId;
	}

	public UserSchoolKey() {
		super();
	}

	@Override
	public String toString() {
		return "UserSchoolKey [userId=" + userId + ", schoolId=" + schoolId
				+ "]";
	}
	

}
