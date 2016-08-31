package cn.SkyShadow.enums;

public enum EmailSendResultEnum {
    FORMAT("FORMAT"),EXITS("EXITS"),UN_LOGIN("UN_LOGIN"),VALIDATED("VALIDATED"),
    OVERCLOCKING("OVERCLOCKING"),UN_VALIDATE("UN_VALIDATE"), LOGINED("LOGINED"),LONGTIMEOVER("LONGTIMEOVER");
    private String Info;

    public String getInfo() {
        return Info;
    }

    public void setInfo(String info) {
        Info = info;
    }

    EmailSendResultEnum(String info) {
        Info = info;
    }

    public static EmailSendResultEnum stateof(String index) {
        for (EmailSendResultEnum o : values()) {
            if (o.getInfo().equals(index)) {
                return o;
            }
        }
        return null;
    }
}
