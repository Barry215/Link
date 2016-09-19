package cn.SkyShadow.dto.tp;

import java.util.Date;

/**
 * 邮箱验证码发送信息
 */
public class EmailSendSession {
	private Date sendDate;
	private String ValidateCode;
	private String email;

	/**
	 * 获取邮件地址
	 * @return 邮件地址
	 */
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

    /**
     * 获取发送时间
     * @return 发送时间
     */
	public Date getSendDate() {
		return sendDate;
	}

    /**
     * 获取验证码
     * @return 验证码
     */
	public String getValidateCode() {
		return ValidateCode;
	}

	public EmailSendSession(String validateCode,String email) {
		super();
		this.sendDate = new Date();
		ValidateCode = validateCode;
		this.email = email;
	}

	@Override
	public String toString() {
		return "EmailSendSession{" +
				"sendDate=" + sendDate +
				", ValidateCode='" + ValidateCode + '\'' +
				", email='" + email + '\'' +
				'}';
	}
}
