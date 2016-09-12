package cn.SkyShadow.enums;

/**
 * 修改密码结果
 * Created by RichardW on 8/27/2016.
 */
public enum ModifyPaswordEnum {
    /**
     * 未登录
     */
    UN_LOGIN("UN_LOGIN"),
    /**
     * 成功
     */
    Success("Success"),
    /**
     * 旧密码错误
     */
    WrongPsd("WrongPsd"),
    /**
     * 需要验证密保
     */
    NeedKey("NeedKey"),
    /**
     * 新密码格式不对
     */
    FORMAT("FORMAT"),
    /**
     * 用户已经登录
     */
    LOGINED("LOGINED");
    private String info;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    ModifyPaswordEnum(String info) {

        this.info = info;
    }

}
