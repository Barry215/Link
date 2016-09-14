package cn.SkyShadow.enums;

/**
 * 登录结果
 * Created by RichardW on 9/14/2016.
 */
public enum LoginStateEnum {
    ONLINE(1,"在线"),
    OFFLINE(0,"离线");

    LoginStateEnum(int code, String info) {
        this.code = code;
        this.info = info;
    }

    private int code;
    private String info;

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
