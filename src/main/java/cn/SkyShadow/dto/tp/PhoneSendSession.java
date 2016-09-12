package cn.SkyShadow.dto.tp;

import java.util.Date;

/**
 * 手机验证码发送信息
 */
public class PhoneSendSession {
	private Date sendDate;
	private String ValidateCode;
	private String Phone;

    /**
     * 获取手机号码
     * @return 手机号码
     */
	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}
	/**
	 * 发送时间
     * @return 发送时间
	 */
	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

    /**
     * 获取验证码信息
     * @return 验证码信息
     */
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
