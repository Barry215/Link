package cn.SkyShadow.enums;

/**
 * 登录结果
 * Created by RichardW on 9/14/2016.
 */
public enum LoginResultEnum {
    SUCCESS(1,"登陆成功"),
    FAIL(2,"登录失败，用户名或密码有误")
    ;
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

    LoginResultEnum(int code, String info) {
        this.code = code;
        this.info = info;
    }
}
