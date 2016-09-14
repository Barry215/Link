package cn.SkyShadow.enums;

import org.omg.PortableInterceptor.SUCCESSFUL;

/**
 * 注册结果
 * Created by RichardW on 9/14/2016.
 */
public enum RegisterResultEnum {
    ERROR(1,"注册失败，内部错误，请稍候重试"),
    SUCCESS(0,"注册成功"),
    PHONEVALIDATE(2,"手机验证码不正确"),
    EMAILVALIDATE(3,"邮箱验证码不正确");
    private int code;
    private String info;

    RegisterResultEnum(int code, String info) {
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
