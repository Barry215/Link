package cn.SkyShadow.enums;

/**
 * 需要权限的操作
 * Created by RichardW on 9/18/2016.
 */
public enum OperationByAuthorityEnum {
    MODIFY_ORGANIZATION("修改组织基本信息");
    private String info;

    OperationByAuthorityEnum(String info) {
        this.info = info;
    }
}
