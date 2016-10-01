package cn.SkyShadow.enums;

import cn.SkyShadow.tp.service.Impl.ReadProperties;
import cn.SkyShadow.tp.service.ReadConfigFile;

/**
 * session的名称
 * Created by Richard on 16/9/13.
 */
public enum SessionNameEnum {
    user(),
    user_email(),
    user_phone(),
    user_validate_password_protected_phone(),
    user_validate_password_protected_email(),
    user_validate_password_protected_key(),
    user_phone_by_validated(),
    user_email_by_validated(),
    public_phone(),
    public_email(),
    WrongNumEnum();

    private String sessionName;
    private String info;
    private static ReadConfigFile readProperties = new ReadProperties();
    SessionNameEnum() {
        this.sessionName = this.name();
        try {
            read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void read() throws Exception {
        readProperties.setPath("/resultConfig/sessionName.properties");
        this.info = (String) readProperties.getValue(sessionName);
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
