package cn.SkyShadow.enums;

/**
 * Created by RichardW on 8/27/2016.
 */
public enum ModifyPaswordEnum {
    UN_LOGIN("UN_LOGIN"),Success("Success"),WrongPsd("WrongPsd"),NeedKey("NeedKey"), FORMAT("FORMAT"),LOGINED("LOGINED");
    private String info;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    ModifyPaswordEnum(String info) {

        this.info = info;
    }

}
