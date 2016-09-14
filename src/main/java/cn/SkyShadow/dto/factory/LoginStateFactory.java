package cn.SkyShadow.dto.factory;

import cn.SkyShadow.dto.user.LoginState;
import cn.SkyShadow.enums.LoginStateEnum;
import cn.SkyShadow.model.user;

/**
 * 登录结果工厂
 * Created by RichardW on 9/14/2016.
 */
public class LoginStateFactory {
    public static LoginState GetLoginstate(LoginStateEnum loginStateEnum,user user){
        LoginState loginState = new LoginState(loginStateEnum.getCode(),loginStateEnum.getInfo(),user);
        return loginState;
    }
    public static LoginState GetLoginstate(LoginStateEnum loginStateEnum){
        LoginState loginState = new LoginState(loginStateEnum.getCode(),loginStateEnum.getInfo());
        return loginState;
    }
}
