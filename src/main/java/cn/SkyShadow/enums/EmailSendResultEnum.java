package cn.SkyShadow.enums;

/**
 * 邮件发送验证码结果
 */
public enum EmailSendResultEnum {
    /**
     * 邮件格式有问题
     */
    FORMAT("FORMAT"),
    /**
     * 邮件已经存在
     */
    EXITS("EXITS"),
    /**
     * 用户没有登录
     */
    UN_LOGIN("UN_LOGIN"),
    /**
     * 邮件地址已经验证过了
     */
    VALIDATED("VALIDATED"),
    /**
     * 发送频率过高
     */
    OVERCLOCKING("OVERCLOCKING"),
    /**
     * 邮件地址没有验证过
     */
    UN_VALIDATE("UN_VALIDATE"),
    /**
     * 用户在登录状态
     */
    LOGINED("LOGINED"),
    /**
     * 邮件发送超时,请重试
     */
    LONGTIMEOVER("LONGTIMEOVER");
    private String Info;

    public String getInfo() {
        return Info;
    }

    public void setInfo(String info) {
        Info = info;
    }

    EmailSendResultEnum(String info) {
        Info = info;
    }

    public static EmailSendResultEnum stateof(String index) {
        for (EmailSendResultEnum o : values()) {
            if (o.getInfo().equals(index)) {
                return o;
            }
        }
        return null;
    }
}
