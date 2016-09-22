package cn.SkyShadow.factory;

import cn.SkyShadow.dto.opera.OperaObject;
import cn.SkyShadow.model.Organization;
import cn.SkyShadow.model.User;

/**
 * 操作工厂
 * Created by Richard on 16/9/19.
 */
public class OperaFactory {
    public static OperaObject createByUserAndOrg(User user, Organization baseinfo) {
        OperaObject o = new OperaObject();
        o.setBeOprated(baseinfo);
        o.setOperator(user);
        return o;
    }
}
