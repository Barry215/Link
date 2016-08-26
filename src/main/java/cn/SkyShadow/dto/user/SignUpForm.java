package cn.SkyShadow.dto.user;
import  cn.SkyShadow.model.user;
/**
 * Created by RichardW on 8/23/2016.
 */
public class SignUpForm {
    /**
     * 手机验证码
     */
    private String PhoneCode;
    /**
     * 邮箱验证码
     */
    private String EmailCode;
    /**
     * 包装的用户报名信息
     */
    private user user;

    public String getPhoneCode() {
        return PhoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        PhoneCode = phoneCode;
    }

    public String getEmailCode() {
        return EmailCode;
    }

    public void setEmailCode(String emailCode) {
        EmailCode = emailCode;
    }

    public user getUser() {
        return user;
    }

    public void setUser(user user) {
        this.user = user;
    }
}
