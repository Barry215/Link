package cn.SkyShadow.enums;

/**
 * Created by RichardW on 8/25/2016.
 */
public enum PhoneSendResultEnum {
    FORMAT("FORMAT"),EXITS("EXITS"),UN_LOGIN("UN_LOGIN"),VALIDATED("VALIDATED"),OVERCLOCKING("OVERCLOCKING"),UN_VALIDATE("UN_VALIDATE"), LOGINED("LOGINED");
    private String Info;

    public String getInfo() {
        return Info;
    }

    public void setInfo(String info) {
        Info = info;
    }

    PhoneSendResultEnum(String info) {
        Info = info;
    }

    public static PhoneSendResultEnum stateof(String index) {
        for (PhoneSendResultEnum o : values()) {
            if (o.getInfo() == index) {
                return o;
            }
        }
        return null;
    }

}
