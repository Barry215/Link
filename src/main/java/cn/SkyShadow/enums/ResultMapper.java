package cn.SkyShadow.enums;

/**
 * ENUM
 * Created by Richard on 16/9/19.
 */
public enum ResultMapper {
    SUCCESS(true,0,"操作成功"),
    User_UnLogin(1001,"当前操作不支持用户不登录操作,请登录"),
    User_LoginING(1002,"当前操作不支持用户登录操作,请退出后重试"),
    Public_Email_Format(2001,"邮件格式有问题"),
    Public_Email_Exist(2002,"邮件地址已经存在"),
    Public_Email_Validated(2003,"邮件地址已经验证过了"),
    Public_No_PasswordProtectedKey(2004,"缺少密保验证"),
    Public_OverTime(2005,"操作超时"),
    Public_Email_UnValidated(2006,"邮件地址没有验证"),
    Public_Email_OverLocking(2007,"发送邮件频率太高,请一分钟后重试")

    ;
    private boolean isSuccess;
    private int code;
    private String info;

    ResultMapper(boolean isSuccess, int code, String info) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.info = info;
    }

    ResultMapper(int code, String info) {
        this.isSuccess = false;
        this.code = code;
        this.info = info;
    }
}
