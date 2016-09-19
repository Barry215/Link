package cn.SkyShadow.enums;

/**
 * ENUM
 * Created by Richard on 16/9/19.
 */
public enum ResultMapper {
    SUCCESS(true,0,"操作成功"),
    User_UnLogin(1001,"当前操作不支持用户不登录操作,请登录"),
    User_LoginING(1002,"当前操作不支持用户登录操作,请退出后重试"),
    User_Login_State_Online(true,1004,"在线状态"),
    User_Login_State_Offline(true,1005,"离线状态"),
    User_Login_Fail(1006,"用户名或密码有误"),
    User_ModifyPsd_WrongOldPsd(1007,"旧密码错误"),
    User_ModifyPsd_Password_Format(1008,"密码格式存在问题,应该为6-20位字符串"),
    User_ResultMapper_Opened(1009,"已经打开了'修改手机号需要验证密保'"),
    User_ResultMapper_Closed(1010,"已经关闭了'修改手机号需要验证密保'"),
    Public_IMG_CODE_Error(4,"图形验证码错误"),
    Public_Email_Format(2001,"邮件格式有问题"),
    Public_Email_Exist(2002,"邮件地址已经存在"),
    Public_Email_Validated(2003,"邮件地址已经验证过了"),
    Public_No_PasswordProtectedKey(2004,"缺少密保验证"),
    Public_OverTime(2005,"操作超时"),
    Public_Email_UnValidated(2006,"邮件地址没有验证"),
    Public_Email_OverLocking(2007,"发送邮件频率太高,请一分钟后重试"),
    Public_Email_MessageSendFail(2008,"没有发送邮箱信息,所以没有办法验证您的邮箱"),
    Public_Email_Error_code(2009,"验证码错误,无法验证您的邮箱"),
    Public_Phone_UnValidated(2010,"手机没有验证"),
    Public_Phone_OverLocking(2011,"发送短信频率太高,请一分钟后重试"),
    Public_Phone_MessageSendFail(2012,"没有发送手机信息,所以没有办法验证您的手机号码"),
    Public_Phone_Error_code(2013,"验证码错误,无法验证您的手机"),
    Public_ILLEGAL_LOCATION(2014,"地址未注册"),
    Public_Phone_Format(2015,"手机格式有问题"),
    Public_Phone_Exist(2016,"手机已经被注册"),
    Public_Phone_Validated(2017,"手机已经验证过了"),
    Org_NULL_ORG(3001,"组织信息为空"),
    Org_NULL_User_ID(3002,"用户名为空"),
    Org_FORMAT_NAME(3003,"组织姓名长度为6-255个字符"),
    Org_ILLEGAL_NAME(3004,"组织名被占用"),
    Org_ILLEGAL_PARENT(3005,"父组织不存在"),
    Org_NULL_LOCATION(3006,"地址未填写"),
    DB_ERROR(10000,"数据库出现错误")

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

    public boolean isSuccess() {
        return isSuccess;
    }

    public int getCode() {
        return code;
    }

    public String getInfo() {
        return info;
    }
}
