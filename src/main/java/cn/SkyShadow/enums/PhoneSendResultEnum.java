package cn.SkyShadow.enums;

/**
 * 手机短信发送验证码结果
 */
public enum PhoneSendResultEnum {
    /**
     * 手机格式有问题
     */
    FORMAT("FORMAT"),
    /**
     * 手机号已经存在
     */
    EXITS("EXITS"),
    /**
     * 用户没有登录
     */
    UN_LOGIN("UN_LOGIN"),
    /**
     * 手机号码已经验证
     */
    VALIDATED("VALIDATED"),
    /**
     * 操作频率过高
     */
    OVERCLOCKING("OVERCLOCKING"),
    /**
     * 手机号没有验证
     */
    UN_VALIDATE("UN_VALIDATE"),
    /**
     * 用户已经登录
     */
    LOGINED("LOGINED"),
    /**
     * 操作超时,请重试
     */
    LONGTIMEOVER("LONGTIMEOVER");
    private String Info;

    public String getInfo() {
        return Info;
    }

    public void setInfo(String info) {
        Info = info;
    }

    PhoneSendResultEnum(String info) {
        Info = info;
    }

    public static PhoneSendResultEnum stateof(String index) {
        for (PhoneSendResultEnum o : values()) {
            if (o.getInfo().equals(index)) {
                return o;
            }
        }
        return null;
    }

}
