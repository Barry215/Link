package cn.SkyShadow.dto.tp;

import java.util.Date;

/**
 * 手机验证码发送信息
 */
public class PhoneSendSession {
	/**
	 * 发送时间
	 */
	private Date sendDate;
	/**
	 * 验证码
	 */
	private String ValidateCode;
	/**
	 * 手机号码
	 */
	private String Phone;

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
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

	public PhoneSendSession(String validateCode,String phone) {
		super();
		this.sendDate = new Date();
		ValidateCode = validateCode;
		this.Phone = phone;
	}

	@Override
	public String toString() {
		return "PhoneSendSession{" +
				"sendDate=" + sendDate +
				", ValidateCode='" + ValidateCode + '\'' +
				", Phone='" + Phone + '\'' +
				'}';
	}
}
