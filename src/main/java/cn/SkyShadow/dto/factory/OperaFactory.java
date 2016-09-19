package cn.SkyShadow.dto.factory;

import cn.SkyShadow.dto.opera.OperaObject;
import cn.SkyShadow.model.organization;
import cn.SkyShadow.model.user;

/**
 * 操作工厂
 * Created by Richard on 16/9/19.
 */
public class OperaFactory {
    public static OperaObject createByUserAndOrg(user user, organization baseinfo) {
        OperaObject o = new OperaObject();
        o.setBeOprated(baseinfo);
        o.setOperator(user);
        return o;
    }
}
