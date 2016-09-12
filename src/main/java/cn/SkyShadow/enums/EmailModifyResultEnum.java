package cn.SkyShadow.enums;

/**
 * 邮箱修改结果
 * Created by RichardW on 8/25/2016.
 *
 */
public enum EmailModifyResultEnum {
    /**
     * 成功
     */
    SUCCESS("SUCCESS"),
    /**
     * 没有发送验证邮件
     */
    MESSAGE_FALL("MESSAGE_FALL"),
    /**
     * 验证码错误
     */
    ERROR_CODE("ERROR_CODE"),
    /**
     * 邮件格式有问题
     */
    FORMAT("FORMAT"),
    /**
     * 邮件地址已经存在
     */
    EXITS("EXITS"),
    /**
     * 用户未登录
     */
    UN_LOGIN("UN_LOGIN"),
    /**
     * 没有验证密保
     */
    NO_KEY("NO_KEY"),
    /**
     * 操作超时,请重试
     */
    OVERTIME("OVERTIME");
    private String Info;

    public String getInfo() {
        return Info;
    }

    public void setInfo(String info) {
        Info = info;
    }

    EmailModifyResultEnum(String info) {
        Info = info;
    }

}
