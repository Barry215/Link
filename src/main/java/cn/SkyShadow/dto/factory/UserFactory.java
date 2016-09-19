package cn.SkyShadow.dto.factory;

import cn.SkyShadow.dto.execution.LoginStateExecution;
import cn.SkyShadow.enums.LoginResultEnum;
import cn.SkyShadow.enums.LoginStateEnum;
import cn.SkyShadow.enums.RegisterResultEnum;
import cn.SkyShadow.model.result_model.LoginResult;
import cn.SkyShadow.model.result_model.RegisterResult;
import cn.SkyShadow.model.user;

/**
 * 登录结果工厂
 * Created by RichardW on 9/14/2016.
 */
public class UserFactory {
    public static LoginStateExecution getLoginStateExecution(LoginStateEnum loginStateEnum){
        return new LoginStateExecution(loginStateEnum.getCode(),loginStateEnum.getInfo());
    }
    public static LoginStateExecution getLoginStateExecution(LoginStateEnum loginStateEnum,user user){
        return new LoginStateExecution(loginStateEnum.getCode(),loginStateEnum.getInfo(),user);
    }

    public static LoginResult GetLoginResult(LoginResultEnum loginResultEnum){
        LoginResult loginResult = new LoginResult(loginResultEnum.getInfo(),loginResultEnum.getCode());
        return loginResult;
    }

    public static RegisterResult GetRegisterResult(RegisterResultEnum registerResultEnum){
        RegisterResult r = new RegisterResult(registerResultEnum.getCode(),registerResultEnum.getInfo());
        return  r;
    }
}
