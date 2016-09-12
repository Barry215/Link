package cn.SkyShadow.enums;

/**
 * 邮件验证结果
 * Created by RichardW on 8/25/2016.
 */
public enum EmailValidateEnum {
    /**
     * 操作成功
     */
    SUCCESS(1, "操作成功"),
    /**
     * 验证码错误
     */
    ERROR_CODE(-2, "验证码错误"),
    /**
     * 未发送短信或短信失效，请重新发送
     */
    MESSAGE_FALL(-3, "未发送短信或短信失效，请重新发送"),
    /**
     * 用户登录验证失败
     */
    LOGIN_FAIL(-1, "用户登录验证失败"),
    /**
     * 用户已经登录
     */
    LOGINED(-4,"用户已经登录");
    private int state;
    private String stateInfo;

    public int getState() {
        return state;
    }


    public String getStateInfo() {
        return stateInfo;
    }


    EmailValidateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }
}
