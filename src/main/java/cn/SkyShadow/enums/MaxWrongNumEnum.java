package cn.SkyShadow.enums;

import cn.SkyShadow.tp.service.Impl.ReadProperties;
import cn.SkyShadow.tp.service.ReadConfigFile;

/**
 * 操作失误免验证码数目
 * Created by RichardW on 9/15/2016.
 */
public enum MaxWrongNumEnum {
    LOGIN("登录"),
    REGISTER("注册"),
    CREATE_ORG("创建组织" ),
    MODIFY_ORG("修改组织基本信息" ),
    ADD_ADMIN("添加管理员"),
    ADD_PARENT("添加父组织"),
    REMOVE_PARENT("移除父组织"),
    DELIVER_ORG("转移组织创建者")
    ;
    private int num;
    private String info;
    private static ReadConfigFile readConfigFile = new ReadProperties();
    private void read(){
        try {
            readConfigFile.setPath("/resultConfig/maxWrongNumEnum.properties");
            this.setNum((Integer) readConfigFile.getValue(this.name()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    MaxWrongNumEnum(String info) {
        this.info = info;
        read();
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
