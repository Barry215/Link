package cn.SkyShadow.enums;

/**
 * 更改"修改密码时需要验证密保" 的结果
 * Created by RichardW on 8/27/2016.
 */
public enum PasswordChangeValidateEnum {
    /**
     * 用户未登录
     */
    UN_LOGIN("UN_LOGIN"),
    /**
     * 已经打开了
     */
    Opened("Opened"),
    /**
     * 已经关闭了
     */
    Closed("Closed"),
    /**
     * 成功
     */
    Success("Success"),
    /**
     * 需要验证密保
     */
    NeedKey("NeedKey");
    private String Info;

    public String getInfo() {
        return Info;
    }

    public void setInfo(String info) {
        Info = info;
    }

    PasswordChangeValidateEnum(String info) {
        Info = info;
    }
}
