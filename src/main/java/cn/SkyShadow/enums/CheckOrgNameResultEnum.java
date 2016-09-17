package cn.SkyShadow.enums;

/**
 * 审查
 * Created by RichardW on 9/17/2016.
 */
public enum CheckOrgNameResultEnum {
    SUCCESS(true,"审查通过");
    private boolean result;
    private String info;

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    CheckOrgNameResultEnum(boolean result, String info) {
        this.result = result;
        this.info = info;
    }
}
