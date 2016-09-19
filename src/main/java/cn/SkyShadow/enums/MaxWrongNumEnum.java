package cn.SkyShadow.enums;

/**
 * 操作失误免验证码数目
 * Created by RichardW on 9/15/2016.
 */
public enum MaxWrongNumEnum {
    LOGIN(3,"登录"),
    REGISTER(0,"注册"),
    CREATE_ORG(3,"创建组织" ),
    MODIFY_ORG(4,"修改组织基本信息" );
    private int num;
    private String info;

    MaxWrongNumEnum(int num, String info) {
        this.num = num;
        this.info = info;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
