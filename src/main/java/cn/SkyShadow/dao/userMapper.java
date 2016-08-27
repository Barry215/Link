package cn.SkyShadow.dao;

import cn.SkyShadow.dto.user.PasswordProtected;
import cn.SkyShadow.model.result_model.LoginResult;
import cn.SkyShadow.model.result_model.RegisterResult;
import cn.SkyShadow.model.user;
import org.apache.ibatis.annotations.Param;

public interface userMapper {

    LoginResult getLoginResult(user user);

    RegisterResult getRegisterResult(user user);

    String HasUserName(String username);

    String HasEmail(String email);

    String HasPhone(String phone);

    user selectByPrimaryKey(Long userId);

    user selectBaseInfo(Long userId);

    int validateEmail(@Param("email") String email, @Param("userId") Long userId);

    int validatePhone(@Param("phone") String phone,@Param("userId") Long userId);

    PasswordProtected getPasswordProtect(Long userId);

    int unValidatePhone(Long userId);

    int unValidateEmail(Long userId);

    user selectBaseInfoByLoginName(String loginName);

    int OpenOrClosePasswordChangeValidate(Long userId);

    int changePassword(@Param("userId")Long userId,@Param("password")String password);
}