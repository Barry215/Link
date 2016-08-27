package cn.SkyShadow.enums;

/**
 * Created by RichardW on 8/27/2016.
 */
public enum PasswordChangeValidateEnum {
    UN_LOGIN("UN_LOGIN"),Opened("Opened"),Closed("Closed"),Success("Success"),NeedKey("NeedKey");
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
