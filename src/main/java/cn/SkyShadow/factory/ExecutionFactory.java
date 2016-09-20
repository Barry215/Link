package cn.SkyShadow.factory;

import cn.SkyShadow.dto.execution.BaseExecution;
import cn.SkyShadow.dto.user.LoginResult;
import cn.SkyShadow.dto.user.PasswordProtected;
import cn.SkyShadow.dto.user.RegisterResult;
import cn.SkyShadow.enums.ResultMapper;

/**
 * Excution工厂
 * Created by RichardW on 9/14/2016.
 */
public class ExecutionFactory {
    public static BaseExecution getExecutionByResultCode(int resultCode){
        return new BaseExecution(resultCode,"操作已执行");
    }
    public static BaseExecution getExecutionByResultCode(int resultCode, String info){
        return new BaseExecution(resultCode,info);
    }
    public static BaseExecution getExecution(ResultMapper ResultMapper, Object o){
        return new BaseExecution(ResultMapper.isSuccess(),ResultMapper.getCode(),ResultMapper.getInfo(),o);
    }
    public static BaseExecution getExecution(ResultMapper ResultMapper){
        return new BaseExecution(ResultMapper.isSuccess(),ResultMapper.getCode(),ResultMapper.getInfo());
    }
    public static BaseExecution getExecution(LoginResult loginResult){
        if (loginResult.getResultNum()==1){
            return getExecution(ResultMapper.SUCCESS);
        }
        return getExecution(ResultMapper.User_Login_Fail);
    }
    public static BaseExecution getExecution(RegisterResult registerResult){
        switch (registerResult.getT_error()){
            case 0: return getExecution(ResultMapper.SUCCESS);
            case 2: return getExecution(ResultMapper.User_Register_UserName_Format);
            case 3: return getExecution(ResultMapper.User_Register_UserName_Exit);
            case 4: return getExecution(ResultMapper.User_ModifyPsd_Password_Format);
            case 5: return getExecution(ResultMapper.Public_Phone_Format);
            case 6: return getExecution(ResultMapper.Public_Phone_Exist);
            case 7: return getExecution(ResultMapper.Public_Email_Format);
            case 8: return getExecution(ResultMapper.Public_Email_Exist);
            default: return  getExecution(ResultMapper.DB_ERROR);
        }

    }
    public static BaseExecution getExecution(PasswordProtected passwordProtected){
        return new BaseExecution(true,0,"",passwordProtected);
    }
}
