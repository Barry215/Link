package cn.SkyShadow.enums;

/**
 * session的名称
 * Created by Richard on 16/9/13.
 */
public enum SessionNameEnum {
    /**
     * user
     */
    user("user","用户信息保持"),
    user_email("user_email","用户在邮箱为空时，发送邮箱一条验证码，要求在登录状态"),
    user_phone("user_phone","用户在手机信息为空时，发送手机一条验证码，要求在登录状态"),
    user_validate_password_protected_phone("user_validate_password_protected_phone","发送短信，用于验证密保，要求登录状态"),
    user_validate_password_protected_email("user_validate_password_protected_email","发送邮箱验证码，用于验证密保，要求登录状态"),
    user_validate_password_protected_key("user_validate_password_protected_key","密保验证,登录状态"),
    user_phone_by_validated("user_phone_by_validated","用于密保验证完成后，修改手机号码时，向手机发送短信，要求用户是登录状态"),
    user_email_by_validated("user_email_by_validated","用于密保验证完成后，修改邮箱时，向邮箱发送验证码，要求用户是登录状态"),
    public_phone("public_phone","注册手机"),
    public_email("public_email","注册邮箱" ),
    WrongNumEnum("WrongNumEnum","用户当前操作的失败次数");

    private String sessionName;
    private String info;

    SessionNameEnum(String sessionName, String info) {
        this.sessionName = sessionName;
        this.info = info;
    }

    public String getSessionName() {

        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
