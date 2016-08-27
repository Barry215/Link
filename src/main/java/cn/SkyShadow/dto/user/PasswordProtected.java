package cn.SkyShadow.dto.user;

/**
 * 用户的密码保护信息
 * Created by RichardW on 8/25/2016.
 */
public class PasswordProtected {
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 手机号码
     */
    private String Phone;
    /**
     * 邮箱地址
     */
    private String Email;
    /**
     * 手机号码是否通过验证，Y/N
     */
    private String PhoneValidate;
    private String PasswoordChangeValidate;

    public String getPasswoordChangeValidate() {
        return PasswoordChangeValidate;
    }

    public void setPasswoordChangeValidate(String passwoordChangeValidate) {
        PasswoordChangeValidate = passwoordChangeValidate;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhoneValidate() {
        return PhoneValidate;
    }

    public void setPhoneValidate(String phoneValidate) {
        PhoneValidate = phoneValidate;
    }

    public String getEmailValidate() {
        return EmailValidate;
    }

    public void setEmailValidate(String emailValidate) {
        EmailValidate = emailValidate;
    }

    /**
     * 邮箱号码是否通过验证，Y/N
     */
    private String EmailValidate;

    @Override
    public String toString() {
        return "PasswordProtected{" +
                "Phone='" + Phone + '\'' +
                ", Email='" + Email + '\'' +
                ", PhoneValidate='" + PhoneValidate + '\'' +
                ", PasswoordChangeValidate='" + PasswoordChangeValidate + '\'' +
                ", EmailValidate='" + EmailValidate + '\'' +
                '}';
    }
}
