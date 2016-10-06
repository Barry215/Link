package cn.SkyShadow.model;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

/**
 * 用户
 */
public class User {
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
	@NotNull(message = "手机号不能为空")
	@Pattern(regexp = "^1[34578]\\d{9}$",message = "手机号码格式错误")
	private String phone;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 国籍
	 */
	private Country nationality;
	/**
	 * 生日
	 */
	private Date birthday;
	/**
	 * 出生地
	 */
	private Location homePlace;
	/**
	 * 居住地
	 */
	private Location livePlace;
	/**
	 * 拥有的朋友分组
	 */
	private List<FriendGroup> friendGroups;
	/**
	 * 职位分组
	 */
	private List<Occupation> occupationList;
	/**
	 * 教育信息
	 */
	private List<UserSchool> user_schools;
	/**
	 * 个人所属邮箱
	 */
	private Mailbox mailbox;
	/**
	 * 个人所属表青
	 */
	private List<Expr> expressions;

	public List<Expr> getExpressions() {
		return expressions;
	}

	public void setExpressions(List<Expr> expressions) {
		this.expressions = expressions;
	}

	public List<Occupation> getOccupationList() {
		return occupationList;
	}

	public void setOccupationList(List<Occupation> occupationList) {
		this.occupationList = occupationList;
	}

	public Mailbox getMailbox() {
		return mailbox;
	}

	public void setMailbox(Mailbox mailbox) {
		this.mailbox = mailbox;
	}

	public List<FriendGroup> getFriendGroups() {
		return friendGroups;
	}

	public void setFriendGroups(List<FriendGroup> friendGroups) {
		this.friendGroups = friendGroups;
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

	public Country getNationality() {
		return nationality;
	}

	public void setNationality(Country nationality) {
		this.nationality = nationality;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Location getHomePlace() {
		return homePlace;
	}

	public void setHomePlace(Location homePlace) {
		this.homePlace = homePlace;
	}

	public Location getLivePlace() {
		return livePlace;
	}

	public void setLivePlace(Location livePlace) {
		this.livePlace = livePlace;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public List<UserSchool> getUser_schools() {
		return user_schools;
	}

	public void setUser_schools(List<UserSchool> user_schools) {
		this.user_schools = user_schools;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username
				+ ", nickname=" + nickname + ", password=" + password
				+ ", email=" + email + ", phone=" + phone + ", sex=" + sex
				+ ", nationality=" + nationality + ", birthday=" + birthday
				+ ", homePlace=" + homePlace + ", livePlace=" + livePlace + "]";
	}

	public User() {
		super();
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public User(String username, String password, String email, String phone) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
	}

	public User(String username, String password, String phone) {
		super();
		this.username = username;
		this.password = password;
		this.phone = phone;
	}

}