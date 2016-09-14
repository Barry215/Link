package cn.SkyShadow.dto.factory;

import cn.SkyShadow.enums.RegisterResultEnum;
import cn.SkyShadow.model.result_model.RegisterResult;

/**
 * 注册结果工厂
 * Created by RichardW on 9/14/2016.
 */
public class RegisterResultFactory {
    public static RegisterResult GetRegisterResult(RegisterResultEnum registerResultEnum){
        RegisterResult r = new RegisterResult(registerResultEnum.getCode(),registerResultEnum.getInfo());
        return  r;
    }
}
