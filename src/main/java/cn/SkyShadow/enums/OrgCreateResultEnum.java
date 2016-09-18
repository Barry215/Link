package cn.SkyShadow.enums;

/**
 * 组织创建结果
 * Created by Richard on 16/9/18.
 */
public enum OrgCreateResultEnum {
    SUCCESS(1,"成功"),
    IMG_CODE(2,"图片验证码错误"),
    NULL_ORG(3,"组织信息为空"),
    NULL_USERID(4,"用户名为空"),
    NO_LOGIN(5,"用户没有登录"),
    FORMAT_NAME(6,"组织姓名长度为6-255个字符"),
    ILLEGAL_NAME(7,"组织名被占用"),
    ILLEGAL_PARENT(8,"父组织不存在"),
    NULL_LOCATION(9,"地址未填写"),
    ILLEGAL_LOCATION(10,"地址未注册"),
    DB_ERROR(11,"数据库出现错误")
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

    OrgCreateResultEnum(int code, String info) {
        this.code = code;
        this.info = info;
    }
}
