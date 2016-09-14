package cn.SkyShadow.dto.factory;

import cn.SkyShadow.enums.LoginResultEnum;
import cn.SkyShadow.model.result_model.LoginResult;

/**
 * 登录结果工厂
 * Created by RichardW on 9/14/2016.
 */
public class LoginResultFactory {
    public static LoginResult GetLoginResult(LoginResultEnum loginResultEnum){
        LoginResult loginResult = new LoginResult(loginResultEnum.getInfo(),loginResultEnum.getCode());
        return loginResult;
    }
}
