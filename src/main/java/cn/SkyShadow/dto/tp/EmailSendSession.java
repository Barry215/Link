package cn.SkyShadow.dto.tp;

import java.util.Date;

/**
 * 邮箱验证码发送信息
 */
public class EmailSendSession {
	/**
	 * 发送时间
	 */
	private Date sendDate;
	/**
	 * 验证码
	 */
	private String ValidateCode;
	/**
	 * 邮箱地址
	 */
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	public String getValidateCode() {
		return ValidateCode;
	}

	public void setValidateCode(String validateCode) {
		ValidateCode = validateCode;
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
