package cn.SkyShadow.dto.user;
import cn.SkyShadow.model.User;
/**
 * 注册填写表单
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
    private User user;
    private String imgcode;

    public String getImgcode() {
        return imgcode;
    }

    public void setImgcode(String imgcode) {
        this.imgcode = imgcode;
    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
