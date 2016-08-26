package cn.SkyShadow.enums;

public enum OrgCreateEnum {
	SUCCESS(1, "创建成功"), USERlOGINFAIL(2, "创建失败，用户无法通过验证"), NAME_FAIL(3,
			"登录失败，组织名不合法，应为2-20字符");

	private int state;
	private String stateInfo;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}

	private OrgCreateEnum(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}

	public static OrgCreateEnum stateof(int index) {
		for (OrgCreateEnum o : values()) {
			if (o.getState() == index) {
				return o;
			}
		}
		return null;
	}
}
