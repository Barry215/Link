package cn.SkyShadow.enums;

/**
 * 操作权限
 * Created by RichardW on 9/18/2016.
 */
public enum OperationAuthorityEnum {
    FULL(1,"拥有权限"),
    APPLY_AVAILABLE(2,"可以申请"),
    NULL(3,"没有权限"),
    APPLY_ALREADY_FINISHED(4,"申请已经被处理"),
    ;
    private int code;
    private String info;

    OperationAuthorityEnum(int code, String info) {
        this.code = code;
        this.info = info;
    }
}
