package cn.SkyShadow.enums;

/**
 * Created by RichardW on 8/25/2016.
 */
public enum PhoneValidateEnum {
    SUCCESS(1, "操作成功"), ERROR_CODE(-2, "验证码错误"), MESSAGE_FALL(-3, "未发送短信或短信失效，请重新发送"), LOGIN_FAIL(-1, "用户登录验证失败"), LOGINED(-4,"LOGINED" );
    private int state;
    private String stateInfo;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    private PhoneValidateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public static PhoneValidateEnum stateof(int index) {
        for (PhoneValidateEnum o : values()) {
            if (o.getState() == index) {
                return o;
            }
        }
        return null;
    }
}
