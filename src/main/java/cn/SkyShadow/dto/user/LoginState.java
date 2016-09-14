package cn.SkyShadow.dto.user;

import cn.SkyShadow.model.user;

/**
 * 登录状态信息
 */
public class LoginState {
	/**
	 * 登录状态数字信息
	 */
	private int state;
	/**
	 * 登录状态详细解释
	 */
	private String stateinfo;
	/**
	 * 若登陆成功，返回基本的用户信息
	 */
	private user baseUser;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStateinfo() {
		return stateinfo;
	}

	public void setStateinfo(String stateinfo) {
		this.stateinfo = stateinfo;
	}

	public user getBaseUser() {
		return baseUser;
	}

	public void setBaseUser(user baseUser) {
		this.baseUser = baseUser;
	}

	public LoginState(int state, String stateinfo, user baseUser) {
		super();
		this.state = state;
		this.stateinfo = stateinfo;
		this.baseUser = baseUser;
	}

	public LoginState(int state, String stateinfo) {
		this.state = state;
		this.stateinfo = stateinfo;
	}

	@Override
	public String toString() {
		return "LoginState{" +
				"state=" + state +
				", stateinfo='" + stateinfo + '\'' +
				", baseUser=" + baseUser +
				'}';
	}
}
