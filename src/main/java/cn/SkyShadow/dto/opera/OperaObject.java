package cn.SkyShadow.dto.opera;

import cn.SkyShadow.dto.exception.OperaException;
import cn.SkyShadow.model.Organization;
import cn.SkyShadow.model.User;

/**
 *
 * Created by Richard on 16/9/19.
 */
public class OperaObject {
    private Object operator;
    private Object beOperated;

    public void setOperator(User user){
        if (operator!=null){
            throw new OperaException("只能注入一个操作者");
        }else{
            this.operator = user;
        }
    }
    public void setBeOprated(Organization o){
        if (beOperated!=null){
            throw new OperaException("只能注入一个被操作者");
        }else{
            this.beOperated = o;
        }
    }

    public User getOperator() {
        return (User) operator;
    }

    public Organization getBeOperated() {
        return (Organization) beOperated;
    }
}
