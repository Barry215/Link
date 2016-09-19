package cn.SkyShadow.enums;

import cn.SkyShadow.tp.service.ReadProperties;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * session的名称
 * Created by Richard on 16/9/13.
 */
public enum SessionNameEnum {
    user("user"),
    user_email("user_email"),
    user_phone("user_phone"),
    user_validate_password_protected_phone("user_validate_password_protected_phone"),
    user_validate_password_protected_email("user_validate_password_protected_email"),
    user_validate_password_protected_key("user_validate_password_protected_key"),
    user_phone_by_validated("user_phone_by_validated"),
    user_email_by_validated("user_email_by_validated"),
    public_phone("public_phone"),
    public_email("public_email"),
    WrongNumEnum("WrongNumEnum");

    private String sessionName;
    private String info;
    @Autowired
    private ReadProperties readProperties;

    SessionNameEnum(String sessionName) {
        this.sessionName = sessionName;
        readProperties.setPath("/resultConfig/sessionName.properties");
        this.info = readProperties.getValue(sessionName);
    }

    public String getSessionName() {

        return sessionName;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
