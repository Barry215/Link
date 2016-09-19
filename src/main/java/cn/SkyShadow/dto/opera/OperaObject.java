package cn.SkyShadow.dto.opera;

import cn.SkyShadow.dto.exception.OperaException;
import cn.SkyShadow.model.organization;
import cn.SkyShadow.model.user;

/**
 *
 * Created by Richard on 16/9/19.
 */
public class OperaObject {
    private Object operator;
    private Object beOperated;

    public void setOperator(user user){
        if (operator!=null){
            throw new OperaException("只能注入一个操作者");
        }else{
            this.operator = user;
        }
    }
    public void setBeOprated(organization o){
        if (beOperated!=null){
            throw new OperaException("只能注入一个被操作者");
        }else{
            this.beOperated = o;
        }
    }

    public user getOperator() {
        return (user) operator;
    }

    public organization getBeOperated() {
        return (organization) beOperated;
    }
}
