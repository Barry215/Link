package cn.SkyShadow.dto.factory;

import cn.SkyShadow.enums.ResultMapper;
import cn.SkyShadow.model.result_model.LoginResult;
import cn.SkyShadow.model.result_model.RegisterResult;

/**
 * 登录结果工厂
 * Created by RichardW on 9/14/2016.
 */
public class UserFactory {

    public static LoginResult GetLoginResult(ResultMapper loginResultEnum){
        LoginResult loginResult = new LoginResult(loginResultEnum.getInfo(),loginResultEnum.getCode());
        return loginResult;
    }

    public static RegisterResult GetRegisterResult(ResultMapper resultMapper){
        RegisterResult r = new RegisterResult(resultMapper.getCode(),resultMapper.getInfo());
        return  r;
    }
}
