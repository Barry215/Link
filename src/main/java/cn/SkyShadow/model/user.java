package cn.SkyShadow.model;

import java.util.Date;
import java.util.List;

/**
 * 用户
 */
public class user {
	/**
	 * ID
	 */
	private Long userId;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 昵称
	 */
	private String nickname;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 电邮地址
	 */
	private String email;
	/**
	 * 手机号码
	 */
	private String phone;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 国籍
	 */
	private country nationality;
	/**
	 * 生日
	 */
	private Date bothday;
	/**
	 * 出生地
	 */
	private location homeplace;
	/**
	 * 居住地
	 */
	private location liveplace;
	/**
	 * 拥有的朋友分组
	 */
	private List<friendgroup> friendgroups;
	/**
	 * 职位分组
	 */
	private List<occupation> ocupationList;
	/**
	 * 教育信息
	 */
	private List<user_school> user_schools;
	/**
	 * 个人所属邮箱
	 */
	private mailbox mailbox;
	/**
	 * 个人所属表青
	 */
	private List<expr> exprs;

	public List<expr> getExprs() {
		return exprs;
	}

	public void setExprs(List<expr> exprs) {
		this.exprs = exprs;
	}

	public List<occupation> getOcupationList() {
		return ocupationList;
	}

	public void setOcupationList(List<occupation> ocupationList) {
		this.ocupationList = ocupationList;
	}

	public mailbox getMailbox() {
		return mailbox;
	}

	public void setMailbox(mailbox mailbox) {
		this.mailbox = mailbox;
	}

	public List<friendgroup> getFriendgroups() {
		return friendgroups;
	}

	public void setFriendgroups(List<friendgroup> friendgroups) {
		this.friendgroups = friendgroups;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex == null ? null : sex.trim();
	}

	public country getNationality() {
		return nationality;
	}

	public void setNationality(country nationality) {
		this.nationality = nationality;
	}

	public Date getBothday() {
		return bothday;
	}

	public void setBothday(Date bothday) {
		this.bothday = bothday;
	}

	public location getHomeplace() {
		return homeplace;
	}

	public void setHomeplace(location homeplace) {
		this.homeplace = homeplace;
	}

	public location getLiveplace() {
		return liveplace;
	}

	public void setLiveplace(location liveplace) {
		this.liveplace = liveplace;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public List<user_school> getUser_schools() {
		return user_schools;
	}

	public void setUser_schools(List<user_school> user_schools) {
		this.user_schools = user_schools;
	}

	@Override
	public String toString() {
		return "user [userId=" + userId + ", username=" + username
				+ ", nickname=" + nickname + ", password=" + password
				+ ", email=" + email + ", phone=" + phone + ", sex=" + sex
				+ ", nationality=" + nationality + ", bothday=" + bothday
				+ ", homeplace=" + homeplace + ", liveplace=" + liveplace + "]";
	}

	public user() {
		super();
	}

	public user(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public user(String username, String password, String email, String phone) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
	}

	public user(String username, String password, String phone) {
		super();
		this.username = username;
		this.password = password;
		this.phone = phone;
	}

}