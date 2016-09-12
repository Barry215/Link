package cn.SkyShadow.enums;

/**
 * 修改手机号码结果
 * Created by RichardW on 8/25/2016.
 */
public enum PhoneModifyResultEnum {
    /**
     * 成功
     */
    SUCCESS("SUCCESS"),
    /**
     * 需要发送给手机短信
     */
    MESSAGE_FALL("MESSAGE_FALL"),
    /**
     * 短信验证码不对
     */
    ERROR_CODE("ERROR_CODE"),
    /**
     * 手机号码格式不对
     */
    FORMAT("FORMAT"),
    /**
     * 手机号码已存在
     */
    EXITS("EXITS"),
    /**
     * 用户未登录
     */
    UN_LOGIN("UN_LOGIN"),
    /**
     * 需要验证密保
     */
    NO_KEY("NO_KEY"),
    /**
     * 操作超时
     */
    OVERTIME("OVERTIME");
    private String Info;

    public String getInfo() {
        return Info;
    }

    public void setInfo(String info) {
        Info = info;
    }

    PhoneModifyResultEnum(String info) {
        Info = info;
    }

}
