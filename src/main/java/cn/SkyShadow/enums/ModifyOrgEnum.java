package cn.SkyShadow.enums;

/**
 *
 * Created by Richard on 16/9/19.
 */
public enum ModifyOrgEnum {
    SUCCESS(1,"成功"),
    NO_LOGIN(2,"没有登录"),

    ;
    private int code;
    private String info;

    ModifyOrgEnum(int code, String info) {
        this.code = code;
        this.info = info;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
