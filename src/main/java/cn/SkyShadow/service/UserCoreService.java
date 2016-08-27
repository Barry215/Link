package cn.SkyShadow.service;

import cn.SkyShadow.dto.user.PasswordProtected;
import cn.SkyShadow.model.result_model.LoginResult;
import cn.SkyShadow.model.result_model.RegisterResult;
import cn.SkyShadow.model.user;

public interface UserCoreService {
    LoginResult getLoginResult(user user);

    RegisterResult getRegisterResult_NOEMAIL(user user);

    RegisterResult getRegisterResult(user user);

    user SelectUserByLogin(user user);

    user selectUserBaseInfo(Long userId);

    int ValidateEmail(Long userId,String Email);

    int ValidatePhone(Long userId,String phone);

    int ChangeValidateEmail(Long userId,String Email);

    int ChangeValidatePhone(Long userId,String phone);

    PasswordProtected getPasswordProtectByUserId(Long UserId);

    int OpenOrClosePasswordChangeValidate(Long userId);

    int ChangePasword(Long userId,String password);

}
