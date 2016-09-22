package cn.SkyShadow.enums;

import cn.SkyShadow.tp.service.Impl.ReadProperties;
import cn.SkyShadow.tp.service.Impl.ReadXml;
import cn.SkyShadow.tp.service.ReadConfigFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 需要权限的操作
 * Created by RichardW on 9/18/2016.
 */
public enum OperationByAuthorityEnum {
    MODIFY_ORGANIZATION();
    private String info;
    private ReadConfigFile readProperties = new ReadProperties();

    OperationByAuthorityEnum() {
        try {
            readProperties.setPath("/resultConfig/OperationByAuthority.properties");
            this.info = (String) readProperties.getValue(this.getClass().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
