package cn.SkyShadow.enums;

/**
 * Created by RichardW on 8/25/2016.
 */
public enum PhoneModifyResultEnum {
    SUCCESS("SUCCESS"), MESSAGE_FALL("MESSAGE_FALL"), ERROR_CODE("ERROR_CODE"), FORMAT("FORMAT"), EXITS("EXITS"),
    UN_LOGIN("UN_LOGIN"), NO_KEY("NO_KEY"), OVERTIME("OVERTIME");
    private String Info;

    public String getInfo() {
        return Info;
    }

    public void setInfo(String info) {
        Info = info;
    }

    PhoneModifyResultEnum(String info) {
        Info = info;
    }

    public static PhoneModifyResultEnum stateof(String index) {
        for (PhoneModifyResultEnum o : values()) {
            if (o.getInfo() == index) {
                return o;
            }
        }
        return null;
    }
}
